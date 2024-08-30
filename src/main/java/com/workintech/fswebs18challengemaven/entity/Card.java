package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "Card", schema = "fsweb")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "value")
    private Integer value;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Color color;

    public Card(Type type, Integer value, Color color) {
        this.type = type;
        this.value = value;
        this.color = color;
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid card configuration");
        }
    }


    public boolean isValid() {
        if ((type != null && value != null) || (type == null && value == null)) {
            return false;
        }

        if ("JOKER".equals(type)) {
            return value == null && color == null;
        }

        return true;
    }
}
