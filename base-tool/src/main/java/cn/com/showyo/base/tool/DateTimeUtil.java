package cn.com.showyo.base.tool;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>日期时间工具</p>
 * @author 游修良
 * @date 2020年2月8日 上午9:49:26
 */
public class DateTimeUtil {
	
	private static final SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final SimpleDateFormat HH_mm_ss = new SimpleDateFormat("HH:mm:ss");

	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月16日 下午4:49:28 
	 * @说明 :拿到当前日期字符串（yyyy-MM-dd）
	 * @return
	 */
	public static String getFormatDateNow() {
		Date now = new Date();
		return yyyy_MM_dd.format(now);
	}
	
	/**
	 * 
	 * @author 游修良
	 * @time 2018年11月16日 下午4:55:56 
	 * @说明 :拿到当前时间字符串（HH:mm:ss）
	 * @return
	 */
	public static String getFormatTimeNow() {
		Date now = new Date();
		return HH_mm_ss.format(now);
	}
	
	/**
	 * 
	 *@author 游修良
	 *@date 2018年12月11日--下午10:24:48
	 *@instruction 方法说明：拿到当前日期时间字符串（yyyy-MM-dd HH:mm:ss）
	 * @return
	 */
	public static String getDateTimeNow() {
		return LocalDate.now().toString() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
    /**
     * <p>获取某年某月的第一天</p>
     * @Author you_xl
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * <p>获取某年某月的最后一天</p>
     * @Author you_xl
     * @param year
     * @param month
     * @return
     */
    public  static String getLastDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

}
