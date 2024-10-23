package com.sajaya.backend.SJA.model;

import java.io.Serializable;

public interface BaseEntity extends Serializable {
    int hashCode();
    boolean equals(Object var1);
    String toString();}