package boss_android.transparent_factory.util;

import java.util.regex.Pattern;

import boss_android.transparent_factory.common.Config;

/**
 * 正则匹配类
 *
 * @author YangCihang
 * @since 17/8/25.
 * email yangcihang@hrsoft.net
 */

public class RegexUtil {
    // 手机号的正则,11位手机号
    private static final String REGEX_MOBILE = "[1][3,4,5,7,8][0-9]{9}$";

    //手机号正则
    public static boolean checkMobile(String phone) {
        return Pattern.matches(REGEX_MOBILE, phone);
    }

    //验证邮箱
    public static boolean checkEmail(String email) {
        return Pattern.matches(Config.EMAIL_REGEX, email);
    }
}

