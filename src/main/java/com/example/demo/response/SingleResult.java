package com.example.demo.response;

import lombok.Data;

@Data
public class SingleResult<T> extends CommonResult {

    private Object data;

}
