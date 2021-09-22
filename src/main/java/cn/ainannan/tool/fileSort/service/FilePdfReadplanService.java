package cn.ainannan.tool.fileSort.service;

import cn.ainannan.base.service.BaseService;
import cn.ainannan.commons.utils.LocalDateUtil;
import cn.ainannan.tool.fileSort.bean.FilePdfReadline;
import cn.ainannan.tool.fileSort.bean.FilePdfReadplan;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadlineMapper;
import cn.ainannan.tool.fileSort.mapper.FilePdfReadplanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = false)
public class FilePdfReadplanService extends BaseService<FilePdfReadplanMapper, FilePdfReadplan> {

    @Autowired
    private FilePdfReadlineMapper readlineMapper;

    public Integer getPastReadNum(FilePdfReadplan bean) {
        int readnum = 0;

        if("13dc4390ad5240879bb66755181b20fa".equals(bean.getPid())){
            System.out.println("readnum = " + readnum);
        }

        FilePdfReadline filePdfReadline = new FilePdfReadline();
        filePdfReadline.setPid(bean.getPid());

        List<FilePdfReadline> readlineList = readlineMapper.findList(filePdfReadline);

        Optional<FilePdfReadline> fprO = readlineList.stream()
                .filter(item -> LocalDate.now().isEqual(
                        LocalDateUtil.parseLocalDate(item.getReadtime()))
                ).max((FilePdfReadline a, FilePdfReadline b) -> a.getPagenum() - b.getPagenum());

        /*
        FilePdfReadline query = readlineList.stream()
                    .max((FilePdfReadline a, FilePdfReadline b) ->
                            LocalDateUtil.parseLocalDate(a.getReadtime()).isEqual(LocalDate.now()) ||
                                    LocalDateUtil.parseLocalDate(a.getReadtime())
                                            .isBefore(LocalDateUtil.parseLocalDate(b.getReadtime())) ? -1 : 1
                    ).get();

         */
        if(fprO.isPresent()){

            readlineList.remove(fprO.get());

            Optional<FilePdfReadline> fprO2 = readlineList.stream()
                    .max((FilePdfReadline a, FilePdfReadline b) ->
                        LocalDateUtil.parseLocalDateTime(a.getReadtime())
                                .isBefore(LocalDateUtil.parseLocalDateTime(b.getReadtime()))
                                ? -1 : 1
                    );

            if(fprO2.isPresent()){

                FilePdfReadline yesterdayReadline = fprO2.get();
                readnum = fprO.get().getPagenum() - yesterdayReadline.getPagenum();

            } else {
                readnum = 0;
            }
        }

        return readnum;
    }

    public static void main(String[] args) {

        Date date = new Date();


        LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDate ld = LocalDate.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth());
        LocalDate ld2 = LocalDate.of(2021, 9, 8);


        System.out.println(ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(ld.isEqual(ld2));

    }
}