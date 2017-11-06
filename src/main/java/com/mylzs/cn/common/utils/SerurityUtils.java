package com.mylzs.cn.common.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 17/10/29.
 */
public class SerurityUtils {
    /**
     * 加密字符串
     * @param tar
     * @return
     */
    public static   String encrpty(String tar){
        MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder=new BASE64Encoder();
           tar=  base64Encoder.encode(    md5.digest(tar.getBytes(Charset.forName("utf-8"))));

        } catch (NoSuchAlgorithmException e) {
          System.out.println(e.getMessage());
        }


        return  tar;
    }

    /**
     * 验证两个参数是否相等
     * @param f
     * @param s
     */
    public static  void checkequal(String f,String s) throws  RuntimeException{

       boolean rs = f.equals(s) || (f==s);

       if (!rs){
           throw  new MyException("密码不正确！");
       }
    }

    /**
     * 校验对象是否存在
     * @param f
     * @throws RuntimeException
     */
    public static  void checkExistl(Object f) throws  RuntimeException{



        if (f==null || f==""){
            throw  new MyException("账号不存在！");
        }

    }

    public static   boolean isNotEmpty(Object o){
        if (o==null){
            return false;
        }
        return true;
    }
}
