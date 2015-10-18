package com.swedbank.entry_test.util.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * @author ben
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Position {

    private Integer from;
    private Integer to;

    public Position() {
    }

    public Position(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public Position(Integer position) {
        from = position;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getFrom() {

        return from;
    }

    public Integer getTo() {
        return to;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position position = (Position) obj;
            if (Objects.equals(position.from, from) &&
                    Objects.equals(position.to, to)) {
                return true;
            }
        }
        return false;
    }
}
