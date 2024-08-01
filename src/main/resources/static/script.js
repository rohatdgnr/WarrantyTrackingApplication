const API_URL = 'http://localhost:8080/device'; // Backend API URL'nizi buraya ekleyin

async function fetchDevices() {
    const response = await fetch(API_URL);
    const devices = await response.json();
    renderDevices(devices);
}

function renderDevices(devices) {
    const warrantyList = document.getElementById('warrantyList');
    warrantyList.innerHTML = '';
    devices.forEach(device => {
        const li = document.createElement('li');
        li.innerHTML = `Marka: ${device.brand}, Seri No: ${device.serialNumber}, Model: ${device.model}, Garanti Bitiş: ${device.warranty.expiryDate}
                        <button onclick="deleteDevice(${device.id})">Sil</button>`;
        warrantyList.appendChild(li);
    });
}

async function deleteDevice(id) {
    await fetch(`${API_URL}/${id}`, {
        method: 'DELETE'
    });
    fetchDevices();
}

document.getElementById('addDeviceForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const brand = document.getElementById('deviceBrand').value;
    const serialNumber = document.getElementById('serialNumber').value;
    const model = document.getElementById('modelName').value;
    const expiryDate = document.getElementById('warrantyExpiry').value;

    await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ brand, serialNumber, model, warranty: { expiryDate } })
    });

    fetchDevices();

    // Formu temizle
    document.getElementById('addDeviceForm').reset();
});

// Sayfa yüklendiğinde mevcut cihazları getir
fetchDevices();
