package cn.ainannan.commons;

public class Constant {

	public static final String YES = "1";
	public static final String NO = "0";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";


    // 个人文件夹的子文件夹
	public static String [] picFiles = {
			"20未知年份", "2011及以前", "2012", "2013", "2014", 
			"2015", "2016", "2017", "2018", "2019", "2020", "2021", "Selfie",
			"个人证件", "雪碧"
	};
	
	// 未筛选
	public static final String TIMELINE_PIC_WEISHAIXUAN = "未筛选";
	// 图片状态
	public static final String TIMELINE_PIC_STATE_0 = "0";
	// 缩略图尺寸
	public static final int IMG_THUMBNAIL_SIZE = 300;
	// 缩略图文件夹名
	public static final String IMG_THUMBNAIL_ROOT_SRC = "thumbnail/";

	// session属性名
	// 登录用户
	public static final String LOGIN_USER = "ann_login_user";
	
	
	// ================= 时光轴专区  =======================

	public static final String LABEL_BELONG_XUEBI = "1";
	public static final String LABEL_BELONG_LELE = "2";
	
	public static final String LABEL_STATUS_WEI_TG = "0";
	public static final String LABEL_STATUS_YI_TG = "1";


	// ================= PDF专区  =======================
	public static final String FILE_SORT_PATH = "\\尚羊羊\\fileSort";
	public static final String FILE_SORT_PATH_PDF = "pdf";
	public static final String FILE_SORT_PATH_PDF_THUM = "thum";
	public static final String FILE_SORT_PATH_MUSIC = "music";
	public static final String FILE_SORT_PATH_STR = "FILE_SORT_PATH";

	// 每个subDir里至少存放的文件数
	public static final Integer FILE_SORT_PATH_SUBPATH_FILE_NUM = 100;
	/**
	 * 把路径里的假路径替换为真的
	 */
	public static final int FALSE_TO_TRUE = 1;
	/**
	 * 把路径里的真路径替换为假的
	 */
	public static final int TRUE_TO_FALSE = 2;
	
}
