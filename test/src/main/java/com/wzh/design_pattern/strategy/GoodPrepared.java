package com.wzh.design_pattern.strategy;

public class GoodPrepared {
        Company company;
        GoodPrepared(Company company){
            this.company=company;
        }

        public void job(){
            company.work();
        }

}
