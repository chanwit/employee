package com.chulabhornhospital.employee.domain;

public privileged aspect EmailAdditionFields {

    private boolean Email.dirty = false;

    public void Email.setDirty(boolean value) {
        this.dirty = value;
    }

    public boolean Email.isDirty() {
        return this.dirty;
    }

    after(Email email): set(String Email.emailAddress) && this(email) {
        email.setDirty(true);
    }

}
