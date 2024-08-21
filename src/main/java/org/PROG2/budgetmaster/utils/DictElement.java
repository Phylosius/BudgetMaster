package org.PROG2.budgetmaster.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictElement<t1, t2> {
    private t1 key;
    private t2 value;
    private int intValue;

    public DictElement(t1 key, t2 value) {
        this.key = key;
        this.value = value;
        this.intValue = 0;
    }

    @Override
    public String toString() {
        return "DictElement{" +
                "key=" + key +
                ", value=" + value +
                ", intValue=" + intValue +
                '}';
    }
}
