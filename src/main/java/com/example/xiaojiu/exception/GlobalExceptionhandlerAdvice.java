// package com.example.xiaojiu.exception;

// import org.slf4j.LoggerFactory;
// import com.example.xiaojiu.pojo.ResponseMessage;
// // import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.slf4j.Logger;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @RestControllerAdvice
// public class GlobalExceptionhandlerAdvice {

//     Logger logger = LoggerFactory.getLogger(GlobalExceptionhandlerAdvice.class);

//     @ExceptionHandler({ Exception.class })
//     public ResponseMessage handleException(Exception e, HttpServletRequest request,
//             HttpServletResponse response) {
//         logger.error("服务器内部错误", e);
//         return new ResponseMessage<>(500, "服务器内部错误", null);
//     }

// }
package com.example.xiaojiu.exception;

import com.example.xiaojiu.pojo.ResponseMessage;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionhandlerAdvice {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionhandlerAdvice.class);

    // 新增：处理验证失败的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMessage<String> handleValidationException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));
        
        logger.warn("参数验证失败: {}", errorMessage);
        return new ResponseMessage<>(400, errorMessage, null);
    }

    // 修改：优化原始异常处理
    @ExceptionHandler({ Exception.class })
    public ResponseMessage<String> handleException(Exception e) {
        logger.error("服务器内部错误: {}", e.getMessage(), e); // 添加详细错误信息
        return new ResponseMessage<>(500, "服务器内部错误", null);
    }
}