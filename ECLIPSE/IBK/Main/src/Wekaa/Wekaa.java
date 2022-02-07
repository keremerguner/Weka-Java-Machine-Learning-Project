package Wekaa;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.lazy.IBk;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class Wekaa {

	public static void main(String[] args) throws Exception {

		
		DataSource source = new DataSource("C:\\Users\\ergun\\Desktop\\originalDataSet.arff");
		Instances trainDataset = source.getDataSet();
		
		trainDataset.setClassIndex(0);

		
		
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
																						
			System.out.println("Okul Donem gir : ");
			int okulDonemi = scan.nextInt();
			
			System.out.println("Sinav Yili gir : ");
			int sinavYili = scan.nextInt();
			
			System.out.println("Sinav 1 not Toplamini gir : ");
			int sinavBir = scan.nextInt();
			
			System.out.println("Sinav 2 not Toplamini gir : ");
			int sinavIki = scan.nextInt();
			
			
			

			System.out.println("txt'ye yazildi :  " +okulDonemi + "," + sinavYili + ","  +"?" + "," + sinavBir + "," + sinavIki );
			
			
			
			 File anaDoysaKonum = new File("C:\\Users\\ergun\\Desktop\\test.txt"); 
		        File kopyaDoysaKonum = new File("C:\\Users\\ergun\\Desktop\\testKopya.txt");

		        
		      
		        dosyaKopyala(anaDoysaKonum,kopyaDoysaKonum); 

		        
		      
				String dosyaYolu = "C:\\Users\\ergun\\Desktop\\testKopya.txt";
				 
				try
				{
				FileOutputStream fos = new FileOutputStream(dosyaYolu);
				 
				OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
				
				osw.write("@relation 'Sinav Analizi-weka.filters.unsupervised.attribute.Remove-R4-5,7,9-15'\r\n"
						+ "\r\n"
						+ "@attribute 'Okul Donemi' {3,4,5,6,7,8}\r\n"
						+ "@attribute 'Sinav Yili' {2013,2014,2015}\r\n"
						+ "@attribute 'Ogrenci Ulkeleri' {ELL,EP,Asian,Black,Hispanic,White,Notswd,SWD}\r\n"
						+ "@attribute 'Sinav 1' numeric\r\n"
						+ "@attribute 'Sinav 2' numeric\r\n"
						+ "\r\n"
						+ "@data"
						+ "\r\n");
				
				osw.write(okulDonemi + "," + sinavYili + "," + "?" + ","  + sinavBir + "," + sinavIki);
				osw.close();
				}
				catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
				}
				catch(FileNotFoundException ex)
				{
				System.out.println("Hata : " + ex);
				} 
				catch (IOException e) {
				
				e.printStackTrace();
				}
				
				
				
		}

	
	public static void dosyaKopyala(File anaDoysaKonum,File kopyaDoysaKonum){

        try {

            FileInputStream fis = new FileInputStream(anaDoysaKonum);
            BufferedInputStream okuyucu = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(kopyaDoysaKonum);
            BufferedOutputStream yazici = new BufferedOutputStream(fos);

            int veri = 0; 

            while ((veri = okuyucu.read()) != -1){ 

                byte girdi = (byte) veri; 
                
                
                yazici.write(girdi);

            }

            yazici.flush();  
            yazici.close();  
            okuyucu.close(); 

        }catch (Exception e){
            System.out.println("Hata Kopyalama Baþarýsýz");
            e.printStackTrace();
        }

    }
}

