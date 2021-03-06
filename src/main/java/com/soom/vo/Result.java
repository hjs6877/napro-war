package com.soom.vo;

import lombok.Data;

import java.util.Map;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-19 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
@Data
public class Result {
    private String code;
    private String message;
    private Map<String, String> resultData;
}
