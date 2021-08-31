package com.mybatis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andDept_idIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDept_idIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDept_idEqualTo(Long value) {
            addCriterion("dept_id =", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotEqualTo(Long value) {
            addCriterion("dept_id <>", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idGreaterThan(Long value) {
            addCriterion("dept_id >", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idGreaterThanOrEqualTo(Long value) {
            addCriterion("dept_id >=", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idLessThan(Long value) {
            addCriterion("dept_id <", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idLessThanOrEqualTo(Long value) {
            addCriterion("dept_id <=", value, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idIn(List<Long> values) {
            addCriterion("dept_id in", values, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotIn(List<Long> values) {
            addCriterion("dept_id not in", values, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idBetween(Long value1, Long value2) {
            addCriterion("dept_id between", value1, value2, "dept_id");
            return (Criteria) this;
        }

        public Criteria andDept_idNotBetween(Long value1, Long value2) {
            addCriterion("dept_id not between", value1, value2, "dept_id");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_nameEqualTo(String value) {
            addCriterion("login_name =", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameGreaterThan(String value) {
            addCriterion("login_name >", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLessThan(String value) {
            addCriterion("login_name <", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameLike(String value) {
            addCriterion("login_name like", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotLike(String value) {
            addCriterion("login_name not like", value, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameIn(List<String> values) {
            addCriterion("login_name in", values, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "login_name");
            return (Criteria) this;
        }

        public Criteria andLogin_nameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "login_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("user_name =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("user_name >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("user_name <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("user_name like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("user_name not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("user_name in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUser_typeEqualTo(String value) {
            addCriterion("user_type =", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThan(String value) {
            addCriterion("user_type >", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThan(String value) {
            addCriterion("user_type <", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLike(String value) {
            addCriterion("user_type like", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotLike(String value) {
            addCriterion("user_type not like", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeIn(List<String> values) {
            addCriterion("user_type in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phonenumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phonenumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phonenumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phonenumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phonenumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phonenumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phonenumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phonenumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phonenumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phonenumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phonenumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phonenumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phonenumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phonenumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andLaw_numIsNull() {
            addCriterion("law_num is null");
            return (Criteria) this;
        }

        public Criteria andLaw_numIsNotNull() {
            addCriterion("law_num is not null");
            return (Criteria) this;
        }

        public Criteria andLaw_numEqualTo(String value) {
            addCriterion("law_num =", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numNotEqualTo(String value) {
            addCriterion("law_num <>", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numGreaterThan(String value) {
            addCriterion("law_num >", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numGreaterThanOrEqualTo(String value) {
            addCriterion("law_num >=", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numLessThan(String value) {
            addCriterion("law_num <", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numLessThanOrEqualTo(String value) {
            addCriterion("law_num <=", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numLike(String value) {
            addCriterion("law_num like", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numNotLike(String value) {
            addCriterion("law_num not like", value, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numIn(List<String> values) {
            addCriterion("law_num in", values, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numNotIn(List<String> values) {
            addCriterion("law_num not in", values, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numBetween(String value1, String value2) {
            addCriterion("law_num between", value1, value2, "law_num");
            return (Criteria) this;
        }

        public Criteria andLaw_numNotBetween(String value1, String value2) {
            addCriterion("law_num not between", value1, value2, "law_num");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDel_flagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDel_flagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDel_flagEqualTo(String value) {
            addCriterion("del_flag =", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagGreaterThan(String value) {
            addCriterion("del_flag >", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagLessThan(String value) {
            addCriterion("del_flag <", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagLike(String value) {
            addCriterion("del_flag like", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagNotLike(String value) {
            addCriterion("del_flag not like", value, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagIn(List<String> values) {
            addCriterion("del_flag in", values, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "del_flag");
            return (Criteria) this;
        }

        public Criteria andDel_flagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "del_flag");
            return (Criteria) this;
        }

        public Criteria andLogin_ipIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLogin_ipIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_ipEqualTo(String value) {
            addCriterion("login_ip =", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipNotEqualTo(String value) {
            addCriterion("login_ip <>", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipGreaterThan(String value) {
            addCriterion("login_ip >", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipGreaterThanOrEqualTo(String value) {
            addCriterion("login_ip >=", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipLessThan(String value) {
            addCriterion("login_ip <", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipLessThanOrEqualTo(String value) {
            addCriterion("login_ip <=", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipLike(String value) {
            addCriterion("login_ip like", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipNotLike(String value) {
            addCriterion("login_ip not like", value, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipIn(List<String> values) {
            addCriterion("login_ip in", values, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipNotIn(List<String> values) {
            addCriterion("login_ip not in", values, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipBetween(String value1, String value2) {
            addCriterion("login_ip between", value1, value2, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_ipNotBetween(String value1, String value2) {
            addCriterion("login_ip not between", value1, value2, "login_ip");
            return (Criteria) this;
        }

        public Criteria andLogin_dateIsNull() {
            addCriterion("login_date is null");
            return (Criteria) this;
        }

        public Criteria andLogin_dateIsNotNull() {
            addCriterion("login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_dateEqualTo(Date value) {
            addCriterion("login_date =", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateNotEqualTo(Date value) {
            addCriterion("login_date <>", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateGreaterThan(Date value) {
            addCriterion("login_date >", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("login_date >=", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateLessThan(Date value) {
            addCriterion("login_date <", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateLessThanOrEqualTo(Date value) {
            addCriterion("login_date <=", value, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateIn(List<Date> values) {
            addCriterion("login_date in", values, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateNotIn(List<Date> values) {
            addCriterion("login_date not in", values, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateBetween(Date value1, Date value2) {
            addCriterion("login_date between", value1, value2, "login_date");
            return (Criteria) this;
        }

        public Criteria andLogin_dateNotBetween(Date value1, Date value2) {
            addCriterion("login_date not between", value1, value2, "login_date");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreate_byIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_byEqualTo(String value) {
            addCriterion("create_by =", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotEqualTo(String value) {
            addCriterion("create_by <>", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThan(String value) {
            addCriterion("create_by >", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThan(String value) {
            addCriterion("create_by <", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byLike(String value) {
            addCriterion("create_by like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotLike(String value) {
            addCriterion("create_by not like", value, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byIn(List<String> values) {
            addCriterion("create_by in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotIn(List<String> values) {
            addCriterion("create_by not in", values, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_byNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "create_by");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_byEqualTo(String value) {
            addCriterion("update_by =", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotEqualTo(String value) {
            addCriterion("update_by <>", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThan(String value) {
            addCriterion("update_by >", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThan(String value) {
            addCriterion("update_by <", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byLike(String value) {
            addCriterion("update_by like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotLike(String value) {
            addCriterion("update_by not like", value, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byIn(List<String> values) {
            addCriterion("update_by in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotIn(List<String> values) {
            addCriterion("update_by not in", values, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_byNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "update_by");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUser_genreIsNull() {
            addCriterion("user_genre is null");
            return (Criteria) this;
        }

        public Criteria andUser_genreIsNotNull() {
            addCriterion("user_genre is not null");
            return (Criteria) this;
        }

        public Criteria andUser_genreEqualTo(String value) {
            addCriterion("user_genre =", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreNotEqualTo(String value) {
            addCriterion("user_genre <>", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreGreaterThan(String value) {
            addCriterion("user_genre >", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreGreaterThanOrEqualTo(String value) {
            addCriterion("user_genre >=", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreLessThan(String value) {
            addCriterion("user_genre <", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreLessThanOrEqualTo(String value) {
            addCriterion("user_genre <=", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreLike(String value) {
            addCriterion("user_genre like", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreNotLike(String value) {
            addCriterion("user_genre not like", value, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreIn(List<String> values) {
            addCriterion("user_genre in", values, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreNotIn(List<String> values) {
            addCriterion("user_genre not in", values, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreBetween(String value1, String value2) {
            addCriterion("user_genre between", value1, value2, "user_genre");
            return (Criteria) this;
        }

        public Criteria andUser_genreNotBetween(String value1, String value2) {
            addCriterion("user_genre not between", value1, value2, "user_genre");
            return (Criteria) this;
        }

        public Criteria andLaw_faIsNull() {
            addCriterion("law_fa is null");
            return (Criteria) this;
        }

        public Criteria andLaw_faIsNotNull() {
            addCriterion("law_fa is not null");
            return (Criteria) this;
        }

        public Criteria andLaw_faEqualTo(String value) {
            addCriterion("law_fa =", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faNotEqualTo(String value) {
            addCriterion("law_fa <>", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faGreaterThan(String value) {
            addCriterion("law_fa >", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faGreaterThanOrEqualTo(String value) {
            addCriterion("law_fa >=", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faLessThan(String value) {
            addCriterion("law_fa <", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faLessThanOrEqualTo(String value) {
            addCriterion("law_fa <=", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faLike(String value) {
            addCriterion("law_fa like", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faNotLike(String value) {
            addCriterion("law_fa not like", value, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faIn(List<String> values) {
            addCriterion("law_fa in", values, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faNotIn(List<String> values) {
            addCriterion("law_fa not in", values, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faBetween(String value1, String value2) {
            addCriterion("law_fa between", value1, value2, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLaw_faNotBetween(String value1, String value2) {
            addCriterion("law_fa not between", value1, value2, "law_fa");
            return (Criteria) this;
        }

        public Criteria andLedger_iconIsNull() {
            addCriterion("ledger_icon is null");
            return (Criteria) this;
        }

        public Criteria andLedger_iconIsNotNull() {
            addCriterion("ledger_icon is not null");
            return (Criteria) this;
        }

        public Criteria andLedger_iconEqualTo(String value) {
            addCriterion("ledger_icon =", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconNotEqualTo(String value) {
            addCriterion("ledger_icon <>", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconGreaterThan(String value) {
            addCriterion("ledger_icon >", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_icon >=", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconLessThan(String value) {
            addCriterion("ledger_icon <", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconLessThanOrEqualTo(String value) {
            addCriterion("ledger_icon <=", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconLike(String value) {
            addCriterion("ledger_icon like", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconNotLike(String value) {
            addCriterion("ledger_icon not like", value, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconIn(List<String> values) {
            addCriterion("ledger_icon in", values, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconNotIn(List<String> values) {
            addCriterion("ledger_icon not in", values, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconBetween(String value1, String value2) {
            addCriterion("ledger_icon between", value1, value2, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLedger_iconNotBetween(String value1, String value2) {
            addCriterion("ledger_icon not between", value1, value2, "ledger_icon");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionIsNull() {
            addCriterion("login_permission is null");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionIsNotNull() {
            addCriterion("login_permission is not null");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionEqualTo(String value) {
            addCriterion("login_permission =", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionNotEqualTo(String value) {
            addCriterion("login_permission <>", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionGreaterThan(String value) {
            addCriterion("login_permission >", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionGreaterThanOrEqualTo(String value) {
            addCriterion("login_permission >=", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionLessThan(String value) {
            addCriterion("login_permission <", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionLessThanOrEqualTo(String value) {
            addCriterion("login_permission <=", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionLike(String value) {
            addCriterion("login_permission like", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionNotLike(String value) {
            addCriterion("login_permission not like", value, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionIn(List<String> values) {
            addCriterion("login_permission in", values, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionNotIn(List<String> values) {
            addCriterion("login_permission not in", values, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionBetween(String value1, String value2) {
            addCriterion("login_permission between", value1, value2, "login_permission");
            return (Criteria) this;
        }

        public Criteria andLogin_permissionNotBetween(String value1, String value2) {
            addCriterion("login_permission not between", value1, value2, "login_permission");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}