package com.vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteResultExample() {
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

        public Criteria andVoteNameIsNull() {
            addCriterion("vote_name is null");
            return (Criteria) this;
        }

        public Criteria andVoteNameIsNotNull() {
            addCriterion("vote_name is not null");
            return (Criteria) this;
        }

        public Criteria andVoteNameEqualTo(String value) {
            addCriterion("vote_name =", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameNotEqualTo(String value) {
            addCriterion("vote_name <>", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameGreaterThan(String value) {
            addCriterion("vote_name >", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameGreaterThanOrEqualTo(String value) {
            addCriterion("vote_name >=", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameLessThan(String value) {
            addCriterion("vote_name <", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameLessThanOrEqualTo(String value) {
            addCriterion("vote_name <=", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameLike(String value) {
            addCriterion("vote_name like", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameNotLike(String value) {
            addCriterion("vote_name not like", value, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameIn(List<String> values) {
            addCriterion("vote_name in", values, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameNotIn(List<String> values) {
            addCriterion("vote_name not in", values, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameBetween(String value1, String value2) {
            addCriterion("vote_name between", value1, value2, "voteName");
            return (Criteria) this;
        }

        public Criteria andVoteNameNotBetween(String value1, String value2) {
            addCriterion("vote_name not between", value1, value2, "voteName");
            return (Criteria) this;
        }

        public Criteria andPk1NameIsNull() {
            addCriterion("pk1_name is null");
            return (Criteria) this;
        }

        public Criteria andPk1NameIsNotNull() {
            addCriterion("pk1_name is not null");
            return (Criteria) this;
        }

        public Criteria andPk1NameEqualTo(String value) {
            addCriterion("pk1_name =", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameNotEqualTo(String value) {
            addCriterion("pk1_name <>", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameGreaterThan(String value) {
            addCriterion("pk1_name >", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameGreaterThanOrEqualTo(String value) {
            addCriterion("pk1_name >=", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameLessThan(String value) {
            addCriterion("pk1_name <", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameLessThanOrEqualTo(String value) {
            addCriterion("pk1_name <=", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameLike(String value) {
            addCriterion("pk1_name like", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameNotLike(String value) {
            addCriterion("pk1_name not like", value, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameIn(List<String> values) {
            addCriterion("pk1_name in", values, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameNotIn(List<String> values) {
            addCriterion("pk1_name not in", values, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameBetween(String value1, String value2) {
            addCriterion("pk1_name between", value1, value2, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk1NameNotBetween(String value1, String value2) {
            addCriterion("pk1_name not between", value1, value2, "pk1Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameIsNull() {
            addCriterion("pk2_name is null");
            return (Criteria) this;
        }

        public Criteria andPk2NameIsNotNull() {
            addCriterion("pk2_name is not null");
            return (Criteria) this;
        }

        public Criteria andPk2NameEqualTo(String value) {
            addCriterion("pk2_name =", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameNotEqualTo(String value) {
            addCriterion("pk2_name <>", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameGreaterThan(String value) {
            addCriterion("pk2_name >", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameGreaterThanOrEqualTo(String value) {
            addCriterion("pk2_name >=", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameLessThan(String value) {
            addCriterion("pk2_name <", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameLessThanOrEqualTo(String value) {
            addCriterion("pk2_name <=", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameLike(String value) {
            addCriterion("pk2_name like", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameNotLike(String value) {
            addCriterion("pk2_name not like", value, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameIn(List<String> values) {
            addCriterion("pk2_name in", values, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameNotIn(List<String> values) {
            addCriterion("pk2_name not in", values, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameBetween(String value1, String value2) {
            addCriterion("pk2_name between", value1, value2, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk2NameNotBetween(String value1, String value2) {
            addCriterion("pk2_name not between", value1, value2, "pk2Name");
            return (Criteria) this;
        }

        public Criteria andPk1TicketIsNull() {
            addCriterion("pk1_ticket is null");
            return (Criteria) this;
        }

        public Criteria andPk1TicketIsNotNull() {
            addCriterion("pk1_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andPk1TicketEqualTo(Integer value) {
            addCriterion("pk1_ticket =", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketNotEqualTo(Integer value) {
            addCriterion("pk1_ticket <>", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketGreaterThan(Integer value) {
            addCriterion("pk1_ticket >", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk1_ticket >=", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketLessThan(Integer value) {
            addCriterion("pk1_ticket <", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketLessThanOrEqualTo(Integer value) {
            addCriterion("pk1_ticket <=", value, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketIn(List<Integer> values) {
            addCriterion("pk1_ticket in", values, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketNotIn(List<Integer> values) {
            addCriterion("pk1_ticket not in", values, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketBetween(Integer value1, Integer value2) {
            addCriterion("pk1_ticket between", value1, value2, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk1TicketNotBetween(Integer value1, Integer value2) {
            addCriterion("pk1_ticket not between", value1, value2, "pk1Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketIsNull() {
            addCriterion("pk2_ticket is null");
            return (Criteria) this;
        }

        public Criteria andPk2TicketIsNotNull() {
            addCriterion("pk2_ticket is not null");
            return (Criteria) this;
        }

        public Criteria andPk2TicketEqualTo(Integer value) {
            addCriterion("pk2_ticket =", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketNotEqualTo(Integer value) {
            addCriterion("pk2_ticket <>", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketGreaterThan(Integer value) {
            addCriterion("pk2_ticket >", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk2_ticket >=", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketLessThan(Integer value) {
            addCriterion("pk2_ticket <", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketLessThanOrEqualTo(Integer value) {
            addCriterion("pk2_ticket <=", value, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketIn(List<Integer> values) {
            addCriterion("pk2_ticket in", values, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketNotIn(List<Integer> values) {
            addCriterion("pk2_ticket not in", values, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketBetween(Integer value1, Integer value2) {
            addCriterion("pk2_ticket between", value1, value2, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPk2TicketNotBetween(Integer value1, Integer value2) {
            addCriterion("pk2_ticket not between", value1, value2, "pk2Ticket");
            return (Criteria) this;
        }

        public Criteria andPkResultIsNull() {
            addCriterion("pk_result is null");
            return (Criteria) this;
        }

        public Criteria andPkResultIsNotNull() {
            addCriterion("pk_result is not null");
            return (Criteria) this;
        }

        public Criteria andPkResultEqualTo(Integer value) {
            addCriterion("pk_result =", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultNotEqualTo(Integer value) {
            addCriterion("pk_result <>", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultGreaterThan(Integer value) {
            addCriterion("pk_result >", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_result >=", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultLessThan(Integer value) {
            addCriterion("pk_result <", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultLessThanOrEqualTo(Integer value) {
            addCriterion("pk_result <=", value, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultIn(List<Integer> values) {
            addCriterion("pk_result in", values, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultNotIn(List<Integer> values) {
            addCriterion("pk_result not in", values, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultBetween(Integer value1, Integer value2) {
            addCriterion("pk_result between", value1, value2, "pkResult");
            return (Criteria) this;
        }

        public Criteria andPkResultNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_result not between", value1, value2, "pkResult");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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