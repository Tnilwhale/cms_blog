package top.skx1.cms_blog.framework.mvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.skx1.cms_blog.framework.exception.MyException;
import top.skx1.cms_blog.utils.Result;

/*
 * @Author shaokexiang
 * @Date 2021/2/3 11:08
 * @Description //TODO
 * @Param
 * @return
 **/
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(RuntimeException exception){
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result handle(MyException exception){
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }


}
