/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IdCard.Project02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author USER
 */
@Controller
public class controllerIdCard {
   @RequestMapping("/hallo")
   @ResponseBody
   public String getData(@RequestParam("nama") String nama,
           @RequestParam("tanggal") @DateTimeFormat (pattern="yyyy-mm-dd")Date date,
           @RequestParam("gambar") MultipartFile gambar
   ) throws IOException{
       SimpleDateFormat newTanggal= new SimpleDateFormat("dd-mm-yyyy");
       nama = textProcess(nama);
       String born = newTanggal.format(date);
       

       String blob = Base64.encodeBase64String(gambar.getBytes());
       return nama + born + "<br><img src='data:image/jpeg;base64,"+blob+" ' />";
   }
   private String textProcess(String nama){
       String result ="";
       return result;
   }
}

