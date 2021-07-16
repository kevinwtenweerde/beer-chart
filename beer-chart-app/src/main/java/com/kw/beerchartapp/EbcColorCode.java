package com.kw.beerchartapp;

public enum EbcColorCode {
    NULL(0, "#FFE699"),
    ONE(1, "#FFE699"),
    TWO(2, "#FFE699"),
    THREE(3, "#FFD878"),
    FOUR(4, "#FFD878"),
    FIVE(5, "#FFCA5A"),
    SIX(6, "#FFCA5A"),
    SEVEN(7, "#FFBF42"),
    EIGHT(8, "#FFBF42"),
    NINE(9, "#FBB123"),
    TEN(10, "#FBB123"),
    ELEVEN(11, "#F8A600"),
    TWELVE(12, "#F8A600"),
    THIRTEEN(13, "#F39C00"),
    FOURTEEN(14, "#F39C00"),
    FIFTEEN(15, "#EA8F00"),
    SIXTEEN(16, "#EA8F00"),
    SEVENTEEN(17, "#E58500"),
    EIGHTEEN(18, "#E58500"),
    NINETEEN(19, "#DE7C00"),
    TWENTY(20, "#DE7C00"),
    TWENTY_ONE(21, "#D77200"),
    TWENTY_TWO(22, "#D77200"),
    TWENTY_THREE(23, "#CF6900"),
    TWENTY_FOUR(24, "#CF6900"),
    TWENTY_FIVE(25, "#CB6200"),
    TWENTY_SIX(26, "#CB6200"),
    TWENTY_SEVEN(27, "#C35900"),
    TWENTY_EIGHT(28, "#C35900"),
    TWENTY_NINE(29, "#BB5100"),
    THIRTY(30, "#BB5100"),
    THIRTY_ONE(31, "#B54C00"),
    THIRTY_TWO(32, "#B54C00"),
    THIRTY_THREE(33, "#B04500"),
    THIRTY_FOUR(34, "#B04500"),
    THIRTY_FIVE(35, "#A63E00"),
    THIRTY_SIX(36, "#A63E00"),
    THIRTY_SEVEN(37, "#A13700"),
    THIRTY_EIGHT(38, "#A13700"),
    THIRTY_NINE(39, "#9B3200"),
    FORTY(40, "#9B3200"),
    FORTY_ONE(41, "#952D00"),
    FORTY_TWO(42, "#952D00"),
    FORTY_THREE(43, "#8E2900"),
    FORTY_FOUR(44, "#8E2900"),
    FORTY_FIVE(45, "#882300"),
    FORTY_SIX(46, "#882300"),
    FORTY_SEVEN(47, "#821E00"),
    FORTY_EIGHT(48, "#821E00"),
    FORTY_NINE(49, "#7B1A00"),
    FIFTY(50, "#7B1A00");

    public final int id;
    public final String htmlCode;

    EbcColorCode(int id, String htmlCode) {
        this.id = id;
        this.htmlCode = htmlCode;
    }

    public static EbcColorCode ofCode(int ebcIndex) {
        for (EbcColorCode ebcColorCode : EbcColorCode.values()) {
            if (ebcColorCode.id == ebcIndex) {
                return ebcColorCode;
            }
        }
        throw new IllegalArgumentException(("Unknown ebc color index " + ebcIndex + " provided"));
    }
}
