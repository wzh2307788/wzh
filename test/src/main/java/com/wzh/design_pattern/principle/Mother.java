package com.wzh.design_pattern.principle;

        public class Mother implements Cooker<Breakfast> {
            @Override
            public Breakfast cook() {
        return new Breakfast();
    }
}
