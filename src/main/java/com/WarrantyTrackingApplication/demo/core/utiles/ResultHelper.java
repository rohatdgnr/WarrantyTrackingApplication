package com.WarrantyTrackingApplication.demo.core.utiles;

import com.WarrantyTrackingApplication.demo.core.result.ResultData;
import com.WarrantyTrackingApplication.demo.core.result.Result;

import org.springframework.http.HttpStatus;



public class ResultHelper {
    public static <T> ResultData<T> created(T data){
        return new ResultData<>(true, Msg.CREATED, "201", data);

    }

    public static <T> ResultData<T> validateError(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "400", data);

    }


    public static <T> ResultData<T> Error500(T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR, "500", data);

    }
    public static <T> ResultData<T> dateFormat(T data) {
        return new ResultData<>(false, Msg.DATE_FORMAT, "400", data);

    }

    public static <T> ResultData<T> success(T data) {
        return new  ResultData<>(false, Msg.OK, "209", data);

    }

    public static Result Ok(){
        return new Result(true,Msg.OK,"200");
    }
    public static <T> ResultData<T> errorWithData(String message, T data, HttpStatus status) {
        return new ResultData<>(false, message, status.value(), data);
    }

    public static Result notFoundError(String msg) {
        return new  Result (false, msg, "404");
    }
}
