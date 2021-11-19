package cn.ainannan.sys.test.image;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DownloadImg {

    public static void main(String[] args) throws Exception, BusinessException {
        method1();

        // download("http://pic1.win4000.com/wallpaper/e/5201b6628d5e1.jpg", "test");
        // ImageUtil.download2("http://pic1.win4000.com/wallpaper/e/5201b6628d5e1.jpg", "H://test//test.jpg");
    }

    public static void method1() throws Exception, BusinessException{

        FileInputStream inputStream = new FileInputStream("H:\\尚羊羊\\临时文件夹\\朝鲜地图1945美国军用地图.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;

        int count = 0;
        while ((str = bufferedReader.readLine()) != null) {

            Document doc = Jsoup.parseBodyFragment(str);
            Elements e = doc.getElementsByTag("a");
            String href = e.attr("href");

            href = href.replace("http:", "https:");

            System.out.println("href = " + href);

            String[] names = str.split("</a>")[1].split(",")[0].split("Sheet")[1].split(" ");
            // System.out.println(str.split("</a>")[1]);
            String name = e.html() + "_" + names[1] + "_" + names[2];

            // download(href, name);
            // downloadPicture(href, "H://test", name + ".jpg");
            ImageUtil.download2(href, "H://test//" + name + ".jpg");
        }

        //close
        inputStream.close();
        bufferedReader.close();
    }

    //java 通过url下载图片保存到本地
    public static void download(String urlString, String filename) throws Exception {
        System.out.println("urlString = " + urlString);
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        String fn = "H://test//" + filename + ".jpg";  //下载路径及下载图片名称
        File file = new File(fn);
        FileOutputStream os = new FileOutputStream(file, true);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        Thread.sleep(2000L);
        // System.out.println(fn);
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }
    /**
     * 传入要下载的图片的url列表，将url所对应的图片下载到本地
     *
     */
    public static void downloadPicture(Object urlString, String imagePath, String name) throws BusinessException {

        File file = new File(imagePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        if (urlString == null) {
            throw new BusinessException("下载图片地址为空");
        }
        URL url = null;
        try {
            url = new URL(urlString.toString());

            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imagePath + File.separator + name));

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }

            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new BusinessException("下载、保存图片失败" + urlString);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("保存图片失败" + urlString);
        }
    }

    /**
     * 传入要下载的图片的url列表，将url所对应的图片下载到本地
     *
     * @param urlList
     */
    private void downloadPicture(ArrayList<String> urlList) {
        URL url = null;
        int imageNumber = 100;

        for (String urlString : urlList) {
            try {
                url = new URL(urlString);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String imageName = "D:\\capture\\program\\" + imageNumber + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));

                byte[] buffer = new byte[1024];
                int length;

                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }

                dataInputStream.close();
                fileOutputStream.close();
                imageNumber++;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
