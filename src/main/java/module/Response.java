package module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "error", "data", "pagination"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Data
public class Response<T> {
    @JsonProperty("status")
    private Integer code;
    @JsonProperty("error")
    private String errorMessage;
    @JsonProperty("data")
    private T data;
}
