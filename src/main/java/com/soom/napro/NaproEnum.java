package com.soom.napro;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-04-10 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public enum NaproEnum {
    M_NO("NO_MENSE", 0),
    M_H("H", 0),
    M_M("M", 0),
    M_L("L", 0),
    M_VL("VL", 0),
    M_B("B", 0),
    L_ZERO("0", 0),
    L_TWO("2", 2),
    L_TWO_W("2", 2),
    L_FOUR("4", 4),
    L_SIX("6", 6),
    L_EIGHT("8", 8),
    L_TEN("10", 10),

    S1_D("D", 1),
    S1_W("W", 1),
    S1_S("S", 1),

    S2_C("C", 2),
    S2_CK("CK", 2),
    S2_G("G", 2),
    S2_K("K", 4),
    S2_L("L", 5),
    S2_P("P", 2),
    S2_Y("Y", 2);

    private String code;
    private int score;

    NaproEnum(String code, int score) {
        this.code = code;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public int getScore() {
        return score;
    }
}
