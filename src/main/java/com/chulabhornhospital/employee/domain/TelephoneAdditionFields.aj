package com.chulabhornhospital.employee.domain;

public privileged aspect TelephoneAdditionFields {

    private boolean Telephone.dirty = false;

    public boolean Telephone.isDirty() {
        return dirty;
    }

    public void Telephone.setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    after(Telephone tel): set(String Telephone.telNumber) && this(tel) {
        tel.setDirty(true);
    }

}
