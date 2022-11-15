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
import org.springframework.ui.Model;
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
   @RequestMapping("/viewpage")
   public String getData(@RequestParam("nama") String nama,
           @RequestParam("tanggal") @DateTimeFormat (pattern="yyyy-mm-dd")Date tanggal,
           @RequestParam("gambar") MultipartFile gambar,
           Model IDCard
           
   ) throws IOException{
       SimpleDateFormat newTanggal= new SimpleDateFormat("dd-mm-yyyy");
     
       String born = newTanggal.format(tanggal);

       String blob = Base64.encodeBase64String(gambar.getBytes());
       String gambarrp= "data:image/jpg;base64,".concat(blob);
       
        IDCard.addAttribute("nma", nama);
        IDCard.addAttribute("tgl", tanggal);
        IDCard.addAttribute("gbr", gambarrp);

        return "viewpage";
   }
 
}
