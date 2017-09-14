package boss_android.transparent_factory.util;

import java.math.BigDecimal;

/**
 * @author YangCihang
 * @since 17/9/12.
 * email yangcihang@hrsoft.net
 */

public class FloatUtil {
    public static float getFloat(float num, int scale) {
        int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) num);
        bd = bd.setScale(scale, roundingMode);
        return bd.floatValue();
    }
}
