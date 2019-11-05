package module;

import javafx.scene.control.Pagination;

public class ModelToResponseMapper {
    private ModelToResponseMapper() {
        // Utility classes should not have a public or default constructor.
    }

    public static <T> Response<T> mapThisError(ApiResponseStatus apiResponseStatus,
                                               String errorMessage) {

        Response<T> response = new Response<>();
        response.setCode(apiResponseStatus.value());
        response.setErrorMessage(errorMessage);

        return response;
    }

    public static <T> Response<T> mapThisError(ApiResponseStatus apiResponseStatus) {

        Response<T> response = new Response<>();
        response.setCode(apiResponseStatus.value());
        response.setErrorMessage(apiResponseStatus.getReasonPhrase());

        return response;
    }

    public static <T> Response<T> mapThisSuccess(T data, Pagination pagination) {

        Response<T> response = new Response<>();
        response.setCode(ApiResponseStatus.SUCCESS.value());
        response.setData(data);

        return response;
    }

    public static <T> Response<T> mapThisSuccess(T data) {

        Response<T> response = new Response<>();
        response.setCode(ApiResponseStatus.SUCCESS.value());
        response.setData(data);

        return response;
    }

    public static <T> Response<T> mapThisSuccess() {

        Response<T> response = new Response<>();
        response.setCode(ApiResponseStatus.SUCCESS.value());

        return response;
    }
}
