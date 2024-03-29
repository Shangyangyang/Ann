package cn.ainannan.sys.test;

import java.io.File;
import java.util.List;

public class Mp4SplitTest {
    public static boolean processImg(String veido_path, String ffmpeg_path) {
        File file = new File(veido_path);
        if (!file.exists()) {
            System.err.println("路径[" + veido_path + "]对应的视频文件不存在!");
            return false;
        }
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(veido_path);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("8");// 这个参数是设置截取视频多少秒时的画面
        // commands.add("-t");
        // commands.add("0.001");
        commands.add("-s");
        commands.add("480x852");
        commands.add(veido_path.substring(0, veido_path.lastIndexOf("."))
                .replaceFirst("vedio", "file") + ".jpg");
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            System.out.println("截取成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        processImg("H:\\尚羊羊\\图片\\网络视频\\000UlKK7lx07yXGyGh0Y01041200eVSh0E010.mp4",
                "C:\\ProgramData\\Red Giant\\Trapcode Particular\\Tools\\ffmpeg.exe");
    }

}
