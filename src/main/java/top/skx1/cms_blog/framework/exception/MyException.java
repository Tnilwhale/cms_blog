package top.skx1.cms_blog.framework.exception;

/*
 * @Author shaokexiang
 * @Date 2021/2/3 11:18
 * @Description //TODO
 * @Param 
 * @return 
 **/
public class MyException extends RuntimeException {
    public  MyException(){

    }

    public MyException(String message){
        super(message);
    }
}
