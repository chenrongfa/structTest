package com.yy.struct.struct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by crf on 2017/12/9
 * QQ:952786280
 * email:18720979339@163.com
 * company:逸臣有限公司
 * function:
 */
@RestController
public class CommonController {
   @ GetMapping("/course_detail")
    public String getCourse(){
       StringBuffer result = getStringBuffer("course_detail.json");
        return result.toString();
    }  @ GetMapping("/home_recommend")
    public String getRecommend(){
       StringBuffer result = getStringBuffer("home_data.json");
        return result.toString();
    }  @ GetMapping("/check_update")
    public String checkUpdate(){
       StringBuffer result = getStringBuffer("update.json");
        return result.toString();
    }  @ GetMapping("/search")
    public String getSearch(){
       StringBuffer result = getStringBuffer("search.json");
        return result.toString();
    }
    @ GetMapping("/login")
    public String getUserInfo(HttpServletRequest request){
       StringBuffer result = getStringBuffer("user_info.json");

        return result.toString();
    }


    private StringBuffer getStringBuffer(String path) {
        InputStream resourceAsStream=null;
        StringBuffer result=new StringBuffer();
        File file=new File("G:\\web\\struct\\src\\main\\resources\\static",path);
        try {
            resourceAsStream =new FileInputStream(file);
            byte []ch=new byte[1024];
            int len=0;

            while((len=resourceAsStream.read(ch))!=-1){
                String s=new String(ch,0,len);
                 result.append(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
    @PostMapping("/post")
    public String  login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username);
        System.out.println(password);

        return "ok";
    }
    @PostMapping("/upload")
    public String  upload(MultipartFile file,HttpServletRequest request){
        System.out.println(file.getName());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
     //   String image = request.getContextPath();
      //  System.out.println(image);
        File target=new File("G:\\web\\struct\\src\\main\\resources");
        if(!target.exists())
            target.mkdirs();

        try {

         target=new File("G:\\web\\struct\\src\\main\\resources",file.getOriginalFilename());

            file.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }
    @GetMapping("/download")
    public String  download(HttpServletResponse response) {
        System.out.printf("laile ");

        FileInputStream fileInputStream=null;
        File target = new File("G:\\web\\struct\\src\\main\\resources", "hello.txt");
        response.addHeader("Content-Disposition","attachment;filename=hello.txt");
        try {
            fileInputStream = new FileInputStream(target);
            ServletOutputStream outputStream = response.getOutputStream();
            int len=0;
            byte br[]=new byte[1024];
            while((len=fileInputStream.read(br))!=-1){

                outputStream.write(br,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
