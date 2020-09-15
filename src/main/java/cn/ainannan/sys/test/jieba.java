package cn.ainannan.sys.test;

import cn.ainannan.commons.utils.StringUtils;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class jieba {
    private JiebaSegmenter segmenter = new JiebaSegmenter();
    String sentences = "北京京天威科技发展有限公司大庆车务段的装车数量";
    String huji = "山东省济南市天桥区水晶小区6号楼2单元302号";
    String juzhu = "天桥区济洛路116号20-1-202";
    String gonganhuji = "山东省济南市天桥区";
    String gonganhujixiangqing = "水晶小区6号楼2单元302号";
    String gaonganAddr = "山东省济南市公安局天桥区分局工人新村南村派出所";

    /**
     * 读取conf目录下所有的自定义词库**.dict文件。
     */
    protected void setUp() throws Exception {
        WordDictionary.getInstance().init(Paths.get("conf"));
    }

    @Test
    public void testCutForSearch() {

//        System.out.println(StringUtils.getSimilarityRatio("工人新村南村派出所", "南村办事处"));
//        System.out.println(StringUtils.getSimilarityRatio("商河县殷巷镇崔铁匠村委会", "商河县公安局殷巷派出所"));
        System.out.println(StringUtils.getSimilarityRatio("郑路镇", "郑路"));

        System.out.println(segmenter.sentenceProcess("济阳街道办事处"));
        System.out.println(segmenter.sentenceProcess("工人新村南村派出所"));
        System.out.println(segmenter.sentenceProcess("南村办事处"));

//        System.out.println(segmenter.sentenceProcess(huji));
//        System.out.println(segmenter.sentenceProcess(juzhu));
//        System.out.println(" ===================== ");
//        System.out.println(segmenter.sentenceProcess(gonganhuji));
//        System.out.println(segmenter.sentenceProcess(gonganhujixiangqing));
//        System.out.println(segmenter.sentenceProcess(gaonganAddr));

        String s1 = "莱芜市";
        String s2 = "济阳区";
        String s3 = "商河县";
        String s4 = "南部山区管委会";

        System.out.println(s1.replaceAll("市|区|县", ""));
        System.out.println(s2.replaceAll("市|区|县", ""));
        System.out.println(s3.replaceAll("市|区|县", ""));

    }
}
