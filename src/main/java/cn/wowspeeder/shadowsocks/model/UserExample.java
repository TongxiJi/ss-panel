package cn.wowspeeder.shadowsocks.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andPassIsNull() {
            addCriterion("pass is null");
            return (Criteria) this;
        }

        public Criteria andPassIsNotNull() {
            addCriterion("pass is not null");
            return (Criteria) this;
        }

        public Criteria andPassEqualTo(String value) {
            addCriterion("pass =", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotEqualTo(String value) {
            addCriterion("pass <>", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThan(String value) {
            addCriterion("pass >", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThanOrEqualTo(String value) {
            addCriterion("pass >=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThan(String value) {
            addCriterion("pass <", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThanOrEqualTo(String value) {
            addCriterion("pass <=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLike(String value) {
            addCriterion("pass like", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotLike(String value) {
            addCriterion("pass not like", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassIn(List<String> values) {
            addCriterion("pass in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotIn(List<String> values) {
            addCriterion("pass not in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassBetween(String value1, String value2) {
            addCriterion("pass between", value1, value2, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotBetween(String value1, String value2) {
            addCriterion("pass not between", value1, value2, "pass");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("passwd is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("passwd is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("passwd =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("passwd <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("passwd >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("passwd >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("passwd <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("passwd <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("passwd like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("passwd not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("passwd in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("passwd not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andTIsNull() {
            addCriterion("t is null");
            return (Criteria) this;
        }

        public Criteria andTIsNotNull() {
            addCriterion("t is not null");
            return (Criteria) this;
        }

        public Criteria andTEqualTo(Integer value) {
            addCriterion("t =", value, "t");
            return (Criteria) this;
        }

        public Criteria andTNotEqualTo(Integer value) {
            addCriterion("t <>", value, "t");
            return (Criteria) this;
        }

        public Criteria andTGreaterThan(Integer value) {
            addCriterion("t >", value, "t");
            return (Criteria) this;
        }

        public Criteria andTGreaterThanOrEqualTo(Integer value) {
            addCriterion("t >=", value, "t");
            return (Criteria) this;
        }

        public Criteria andTLessThan(Integer value) {
            addCriterion("t <", value, "t");
            return (Criteria) this;
        }

        public Criteria andTLessThanOrEqualTo(Integer value) {
            addCriterion("t <=", value, "t");
            return (Criteria) this;
        }

        public Criteria andTIn(List<Integer> values) {
            addCriterion("t in", values, "t");
            return (Criteria) this;
        }

        public Criteria andTNotIn(List<Integer> values) {
            addCriterion("t not in", values, "t");
            return (Criteria) this;
        }

        public Criteria andTBetween(Integer value1, Integer value2) {
            addCriterion("t between", value1, value2, "t");
            return (Criteria) this;
        }

        public Criteria andTNotBetween(Integer value1, Integer value2) {
            addCriterion("t not between", value1, value2, "t");
            return (Criteria) this;
        }

        public Criteria andUIsNull() {
            addCriterion("u is null");
            return (Criteria) this;
        }

        public Criteria andUIsNotNull() {
            addCriterion("u is not null");
            return (Criteria) this;
        }

        public Criteria andUEqualTo(Long value) {
            addCriterion("u =", value, "u");
            return (Criteria) this;
        }

        public Criteria andUNotEqualTo(Long value) {
            addCriterion("u <>", value, "u");
            return (Criteria) this;
        }

        public Criteria andUGreaterThan(Long value) {
            addCriterion("u >", value, "u");
            return (Criteria) this;
        }

        public Criteria andUGreaterThanOrEqualTo(Long value) {
            addCriterion("u >=", value, "u");
            return (Criteria) this;
        }

        public Criteria andULessThan(Long value) {
            addCriterion("u <", value, "u");
            return (Criteria) this;
        }

        public Criteria andULessThanOrEqualTo(Long value) {
            addCriterion("u <=", value, "u");
            return (Criteria) this;
        }

        public Criteria andUIn(List<Long> values) {
            addCriterion("u in", values, "u");
            return (Criteria) this;
        }

        public Criteria andUNotIn(List<Long> values) {
            addCriterion("u not in", values, "u");
            return (Criteria) this;
        }

        public Criteria andUBetween(Long value1, Long value2) {
            addCriterion("u between", value1, value2, "u");
            return (Criteria) this;
        }

        public Criteria andUNotBetween(Long value1, Long value2) {
            addCriterion("u not between", value1, value2, "u");
            return (Criteria) this;
        }

        public Criteria andDIsNull() {
            addCriterion("d is null");
            return (Criteria) this;
        }

        public Criteria andDIsNotNull() {
            addCriterion("d is not null");
            return (Criteria) this;
        }

        public Criteria andDEqualTo(Long value) {
            addCriterion("d =", value, "d");
            return (Criteria) this;
        }

        public Criteria andDNotEqualTo(Long value) {
            addCriterion("d <>", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThan(Long value) {
            addCriterion("d >", value, "d");
            return (Criteria) this;
        }

        public Criteria andDGreaterThanOrEqualTo(Long value) {
            addCriterion("d >=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThan(Long value) {
            addCriterion("d <", value, "d");
            return (Criteria) this;
        }

        public Criteria andDLessThanOrEqualTo(Long value) {
            addCriterion("d <=", value, "d");
            return (Criteria) this;
        }

        public Criteria andDIn(List<Long> values) {
            addCriterion("d in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDNotIn(List<Long> values) {
            addCriterion("d not in", values, "d");
            return (Criteria) this;
        }

        public Criteria andDBetween(Long value1, Long value2) {
            addCriterion("d between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andDNotBetween(Long value1, Long value2) {
            addCriterion("d not between", value1, value2, "d");
            return (Criteria) this;
        }

        public Criteria andTransferEnableIsNull() {
            addCriterion("transfer_enable is null");
            return (Criteria) this;
        }

        public Criteria andTransferEnableIsNotNull() {
            addCriterion("transfer_enable is not null");
            return (Criteria) this;
        }

        public Criteria andTransferEnableEqualTo(Long value) {
            addCriterion("transfer_enable =", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableNotEqualTo(Long value) {
            addCriterion("transfer_enable <>", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableGreaterThan(Long value) {
            addCriterion("transfer_enable >", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_enable >=", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableLessThan(Long value) {
            addCriterion("transfer_enable <", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableLessThanOrEqualTo(Long value) {
            addCriterion("transfer_enable <=", value, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableIn(List<Long> values) {
            addCriterion("transfer_enable in", values, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableNotIn(List<Long> values) {
            addCriterion("transfer_enable not in", values, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableBetween(Long value1, Long value2) {
            addCriterion("transfer_enable between", value1, value2, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andTransferEnableNotBetween(Long value1, Long value2) {
            addCriterion("transfer_enable not between", value1, value2, "transferEnable");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNull() {
            addCriterion("protocol is null");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNotNull() {
            addCriterion("protocol is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolEqualTo(String value) {
            addCriterion("protocol =", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotEqualTo(String value) {
            addCriterion("protocol <>", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThan(String value) {
            addCriterion("protocol >", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("protocol >=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThan(String value) {
            addCriterion("protocol <", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThanOrEqualTo(String value) {
            addCriterion("protocol <=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLike(String value) {
            addCriterion("protocol like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotLike(String value) {
            addCriterion("protocol not like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolIn(List<String> values) {
            addCriterion("protocol in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotIn(List<String> values) {
            addCriterion("protocol not in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolBetween(String value1, String value2) {
            addCriterion("protocol between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotBetween(String value1, String value2) {
            addCriterion("protocol not between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andObfsIsNull() {
            addCriterion("obfs is null");
            return (Criteria) this;
        }

        public Criteria andObfsIsNotNull() {
            addCriterion("obfs is not null");
            return (Criteria) this;
        }

        public Criteria andObfsEqualTo(String value) {
            addCriterion("obfs =", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsNotEqualTo(String value) {
            addCriterion("obfs <>", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsGreaterThan(String value) {
            addCriterion("obfs >", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsGreaterThanOrEqualTo(String value) {
            addCriterion("obfs >=", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsLessThan(String value) {
            addCriterion("obfs <", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsLessThanOrEqualTo(String value) {
            addCriterion("obfs <=", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsLike(String value) {
            addCriterion("obfs like", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsNotLike(String value) {
            addCriterion("obfs not like", value, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsIn(List<String> values) {
            addCriterion("obfs in", values, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsNotIn(List<String> values) {
            addCriterion("obfs not in", values, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsBetween(String value1, String value2) {
            addCriterion("obfs between", value1, value2, "obfs");
            return (Criteria) this;
        }

        public Criteria andObfsNotBetween(String value1, String value2) {
            addCriterion("obfs not between", value1, value2, "obfs");
            return (Criteria) this;
        }

        public Criteria andSwitchedIsNull() {
            addCriterion("switched is null");
            return (Criteria) this;
        }

        public Criteria andSwitchedIsNotNull() {
            addCriterion("switched is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchedEqualTo(Byte value) {
            addCriterion("switched =", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedNotEqualTo(Byte value) {
            addCriterion("switched <>", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedGreaterThan(Byte value) {
            addCriterion("switched >", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedGreaterThanOrEqualTo(Byte value) {
            addCriterion("switched >=", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedLessThan(Byte value) {
            addCriterion("switched <", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedLessThanOrEqualTo(Byte value) {
            addCriterion("switched <=", value, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedIn(List<Byte> values) {
            addCriterion("switched in", values, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedNotIn(List<Byte> values) {
            addCriterion("switched not in", values, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedBetween(Byte value1, Byte value2) {
            addCriterion("switched between", value1, value2, "switched");
            return (Criteria) this;
        }

        public Criteria andSwitchedNotBetween(Byte value1, Byte value2) {
            addCriterion("switched not between", value1, value2, "switched");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Byte value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Byte value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Byte value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Byte value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Byte value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Byte> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Byte> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Byte value1, Byte value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeIsNull() {
            addCriterion("last_get_gift_time is null");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeIsNotNull() {
            addCriterion("last_get_gift_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeEqualTo(Integer value) {
            addCriterion("last_get_gift_time =", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeNotEqualTo(Integer value) {
            addCriterion("last_get_gift_time <>", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeGreaterThan(Integer value) {
            addCriterion("last_get_gift_time >", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_get_gift_time >=", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeLessThan(Integer value) {
            addCriterion("last_get_gift_time <", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeLessThanOrEqualTo(Integer value) {
            addCriterion("last_get_gift_time <=", value, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeIn(List<Integer> values) {
            addCriterion("last_get_gift_time in", values, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeNotIn(List<Integer> values) {
            addCriterion("last_get_gift_time not in", values, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeBetween(Integer value1, Integer value2) {
            addCriterion("last_get_gift_time between", value1, value2, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastGetGiftTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("last_get_gift_time not between", value1, value2, "lastGetGiftTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeIsNull() {
            addCriterion("last_check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeIsNotNull() {
            addCriterion("last_check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeEqualTo(Integer value) {
            addCriterion("last_check_in_time =", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeNotEqualTo(Integer value) {
            addCriterion("last_check_in_time <>", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeGreaterThan(Integer value) {
            addCriterion("last_check_in_time >", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_check_in_time >=", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeLessThan(Integer value) {
            addCriterion("last_check_in_time <", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeLessThanOrEqualTo(Integer value) {
            addCriterion("last_check_in_time <=", value, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeIn(List<Integer> values) {
            addCriterion("last_check_in_time in", values, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeNotIn(List<Integer> values) {
            addCriterion("last_check_in_time not in", values, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeBetween(Integer value1, Integer value2) {
            addCriterion("last_check_in_time between", value1, value2, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastCheckInTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("last_check_in_time not between", value1, value2, "lastCheckInTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeIsNull() {
            addCriterion("last_rest_pass_time is null");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeIsNotNull() {
            addCriterion("last_rest_pass_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeEqualTo(Integer value) {
            addCriterion("last_rest_pass_time =", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeNotEqualTo(Integer value) {
            addCriterion("last_rest_pass_time <>", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeGreaterThan(Integer value) {
            addCriterion("last_rest_pass_time >", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_rest_pass_time >=", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeLessThan(Integer value) {
            addCriterion("last_rest_pass_time <", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeLessThanOrEqualTo(Integer value) {
            addCriterion("last_rest_pass_time <=", value, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeIn(List<Integer> values) {
            addCriterion("last_rest_pass_time in", values, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeNotIn(List<Integer> values) {
            addCriterion("last_rest_pass_time not in", values, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeBetween(Integer value1, Integer value2) {
            addCriterion("last_rest_pass_time between", value1, value2, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andLastRestPassTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("last_rest_pass_time not between", value1, value2, "lastRestPassTime");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("reg_date is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("reg_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(Integer value) {
            addCriterion("reg_date =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(Integer value) {
            addCriterion("reg_date <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(Integer value) {
            addCriterion("reg_date >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_date >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(Integer value) {
            addCriterion("reg_date <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(Integer value) {
            addCriterion("reg_date <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<Integer> values) {
            addCriterion("reg_date in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<Integer> values) {
            addCriterion("reg_date not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(Integer value1, Integer value2) {
            addCriterion("reg_date between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_date not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andInviteNumIsNull() {
            addCriterion("invite_num is null");
            return (Criteria) this;
        }

        public Criteria andInviteNumIsNotNull() {
            addCriterion("invite_num is not null");
            return (Criteria) this;
        }

        public Criteria andInviteNumEqualTo(Integer value) {
            addCriterion("invite_num =", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumNotEqualTo(Integer value) {
            addCriterion("invite_num <>", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumGreaterThan(Integer value) {
            addCriterion("invite_num >", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_num >=", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumLessThan(Integer value) {
            addCriterion("invite_num <", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumLessThanOrEqualTo(Integer value) {
            addCriterion("invite_num <=", value, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumIn(List<Integer> values) {
            addCriterion("invite_num in", values, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumNotIn(List<Integer> values) {
            addCriterion("invite_num not in", values, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumBetween(Integer value1, Integer value2) {
            addCriterion("invite_num between", value1, value2, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andInviteNumNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_num not between", value1, value2, "inviteNum");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNull() {
            addCriterion("is_admin is null");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNotNull() {
            addCriterion("is_admin is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdminEqualTo(Integer value) {
            addCriterion("is_admin =", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotEqualTo(Integer value) {
            addCriterion("is_admin <>", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThan(Integer value) {
            addCriterion("is_admin >", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_admin >=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThan(Integer value) {
            addCriterion("is_admin <", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThanOrEqualTo(Integer value) {
            addCriterion("is_admin <=", value, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminIn(List<Integer> values) {
            addCriterion("is_admin in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotIn(List<Integer> values) {
            addCriterion("is_admin not in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminBetween(Integer value1, Integer value2) {
            addCriterion("is_admin between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("is_admin not between", value1, value2, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andRefByIsNull() {
            addCriterion("ref_by is null");
            return (Criteria) this;
        }

        public Criteria andRefByIsNotNull() {
            addCriterion("ref_by is not null");
            return (Criteria) this;
        }

        public Criteria andRefByEqualTo(Integer value) {
            addCriterion("ref_by =", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByNotEqualTo(Integer value) {
            addCriterion("ref_by <>", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByGreaterThan(Integer value) {
            addCriterion("ref_by >", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByGreaterThanOrEqualTo(Integer value) {
            addCriterion("ref_by >=", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByLessThan(Integer value) {
            addCriterion("ref_by <", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByLessThanOrEqualTo(Integer value) {
            addCriterion("ref_by <=", value, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByIn(List<Integer> values) {
            addCriterion("ref_by in", values, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByNotIn(List<Integer> values) {
            addCriterion("ref_by not in", values, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByBetween(Integer value1, Integer value2) {
            addCriterion("ref_by between", value1, value2, "refBy");
            return (Criteria) this;
        }

        public Criteria andRefByNotBetween(Integer value1, Integer value2) {
            addCriterion("ref_by not between", value1, value2, "refBy");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Integer value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Integer value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Integer value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Integer value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Integer> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Integer> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Integer value1, Integer value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyIsNull() {
            addCriterion("is_email_verify is null");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyIsNotNull() {
            addCriterion("is_email_verify is not null");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyEqualTo(Byte value) {
            addCriterion("is_email_verify =", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyNotEqualTo(Byte value) {
            addCriterion("is_email_verify <>", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyGreaterThan(Byte value) {
            addCriterion("is_email_verify >", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_email_verify >=", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyLessThan(Byte value) {
            addCriterion("is_email_verify <", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyLessThanOrEqualTo(Byte value) {
            addCriterion("is_email_verify <=", value, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyIn(List<Byte> values) {
            addCriterion("is_email_verify in", values, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyNotIn(List<Byte> values) {
            addCriterion("is_email_verify not in", values, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyBetween(Byte value1, Byte value2) {
            addCriterion("is_email_verify between", value1, value2, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andIsEmailVerifyNotBetween(Byte value1, Byte value2) {
            addCriterion("is_email_verify not between", value1, value2, "isEmailVerify");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNull() {
            addCriterion("reg_ip is null");
            return (Criteria) this;
        }

        public Criteria andRegIpIsNotNull() {
            addCriterion("reg_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRegIpEqualTo(String value) {
            addCriterion("reg_ip =", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotEqualTo(String value) {
            addCriterion("reg_ip <>", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThan(String value) {
            addCriterion("reg_ip >", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpGreaterThanOrEqualTo(String value) {
            addCriterion("reg_ip >=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThan(String value) {
            addCriterion("reg_ip <", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLessThanOrEqualTo(String value) {
            addCriterion("reg_ip <=", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpLike(String value) {
            addCriterion("reg_ip like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotLike(String value) {
            addCriterion("reg_ip not like", value, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpIn(List<String> values) {
            addCriterion("reg_ip in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotIn(List<String> values) {
            addCriterion("reg_ip not in", values, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpBetween(String value1, String value2) {
            addCriterion("reg_ip between", value1, value2, "regIp");
            return (Criteria) this;
        }

        public Criteria andRegIpNotBetween(String value1, String value2) {
            addCriterion("reg_ip not between", value1, value2, "regIp");
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