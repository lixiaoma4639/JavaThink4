package java核心编程.第19章枚举;

import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/30.
 * 创建 : xin.li
 * 描述 :
 */
enum Month implements Generator<String> {
    
    ONE("一月"), TWO("二月"), THREE("三月");
    private String desc;

    Month(String desc) {
        this.desc = desc;
    }

    @Override
    public String next() {
        return null;
    }
}
