package com.pangciyuan.note.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteShareExample() {
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

        public Criteria andNoteShareIdIsNull() {
            addCriterion("note_share_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdIsNotNull() {
            addCriterion("note_share_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdEqualTo(Integer value) {
            addCriterion("note_share_id =", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdNotEqualTo(Integer value) {
            addCriterion("note_share_id <>", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdGreaterThan(Integer value) {
            addCriterion("note_share_id >", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_share_id >=", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdLessThan(Integer value) {
            addCriterion("note_share_id <", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdLessThanOrEqualTo(Integer value) {
            addCriterion("note_share_id <=", value, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdIn(List<Integer> values) {
            addCriterion("note_share_id in", values, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdNotIn(List<Integer> values) {
            addCriterion("note_share_id not in", values, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdBetween(Integer value1, Integer value2) {
            addCriterion("note_share_id between", value1, value2, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteShareIdNotBetween(Integer value1, Integer value2) {
            addCriterion("note_share_id not between", value1, value2, "noteShareId");
            return (Criteria) this;
        }

        public Criteria andNoteIdIsNull() {
            addCriterion("note_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteIdIsNotNull() {
            addCriterion("note_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteIdEqualTo(Integer value) {
            addCriterion("note_id =", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotEqualTo(Integer value) {
            addCriterion("note_id <>", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThan(Integer value) {
            addCriterion("note_id >", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_id >=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThan(Integer value) {
            addCriterion("note_id <", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThanOrEqualTo(Integer value) {
            addCriterion("note_id <=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdIn(List<Integer> values) {
            addCriterion("note_id in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotIn(List<Integer> values) {
            addCriterion("note_id not in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdBetween(Integer value1, Integer value2) {
            addCriterion("note_id between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("note_id not between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeIsNull() {
            addCriterion("note_share_type is null");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeIsNotNull() {
            addCriterion("note_share_type is not null");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeEqualTo(Integer value) {
            addCriterion("note_share_type =", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeNotEqualTo(Integer value) {
            addCriterion("note_share_type <>", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeGreaterThan(Integer value) {
            addCriterion("note_share_type >", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_share_type >=", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeLessThan(Integer value) {
            addCriterion("note_share_type <", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeLessThanOrEqualTo(Integer value) {
            addCriterion("note_share_type <=", value, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeIn(List<Integer> values) {
            addCriterion("note_share_type in", values, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeNotIn(List<Integer> values) {
            addCriterion("note_share_type not in", values, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeBetween(Integer value1, Integer value2) {
            addCriterion("note_share_type between", value1, value2, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("note_share_type not between", value1, value2, "noteShareType");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriIsNull() {
            addCriterion("note_share_uri is null");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriIsNotNull() {
            addCriterion("note_share_uri is not null");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriEqualTo(String value) {
            addCriterion("note_share_uri =", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriNotEqualTo(String value) {
            addCriterion("note_share_uri <>", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriGreaterThan(String value) {
            addCriterion("note_share_uri >", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriGreaterThanOrEqualTo(String value) {
            addCriterion("note_share_uri >=", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriLessThan(String value) {
            addCriterion("note_share_uri <", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriLessThanOrEqualTo(String value) {
            addCriterion("note_share_uri <=", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriLike(String value) {
            addCriterion("note_share_uri like", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriNotLike(String value) {
            addCriterion("note_share_uri not like", value, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriIn(List<String> values) {
            addCriterion("note_share_uri in", values, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriNotIn(List<String> values) {
            addCriterion("note_share_uri not in", values, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriBetween(String value1, String value2) {
            addCriterion("note_share_uri between", value1, value2, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareUriNotBetween(String value1, String value2) {
            addCriterion("note_share_uri not between", value1, value2, "noteShareUri");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartIsNull() {
            addCriterion("note_share_start is null");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartIsNotNull() {
            addCriterion("note_share_start is not null");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartEqualTo(Integer value) {
            addCriterion("note_share_start =", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartNotEqualTo(Integer value) {
            addCriterion("note_share_start <>", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartGreaterThan(Integer value) {
            addCriterion("note_share_start >", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_share_start >=", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartLessThan(Integer value) {
            addCriterion("note_share_start <", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartLessThanOrEqualTo(Integer value) {
            addCriterion("note_share_start <=", value, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartIn(List<Integer> values) {
            addCriterion("note_share_start in", values, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartNotIn(List<Integer> values) {
            addCriterion("note_share_start not in", values, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartBetween(Integer value1, Integer value2) {
            addCriterion("note_share_start between", value1, value2, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andNoteShareStartNotBetween(Integer value1, Integer value2) {
            addCriterion("note_share_start not between", value1, value2, "noteShareStart");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSharePinIsNull() {
            addCriterion("share_pin is null");
            return (Criteria) this;
        }

        public Criteria andSharePinIsNotNull() {
            addCriterion("share_pin is not null");
            return (Criteria) this;
        }

        public Criteria andSharePinEqualTo(String value) {
            addCriterion("share_pin =", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinNotEqualTo(String value) {
            addCriterion("share_pin <>", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinGreaterThan(String value) {
            addCriterion("share_pin >", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinGreaterThanOrEqualTo(String value) {
            addCriterion("share_pin >=", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinLessThan(String value) {
            addCriterion("share_pin <", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinLessThanOrEqualTo(String value) {
            addCriterion("share_pin <=", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinLike(String value) {
            addCriterion("share_pin like", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinNotLike(String value) {
            addCriterion("share_pin not like", value, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinIn(List<String> values) {
            addCriterion("share_pin in", values, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinNotIn(List<String> values) {
            addCriterion("share_pin not in", values, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinBetween(String value1, String value2) {
            addCriterion("share_pin between", value1, value2, "sharePin");
            return (Criteria) this;
        }

        public Criteria andSharePinNotBetween(String value1, String value2) {
            addCriterion("share_pin not between", value1, value2, "sharePin");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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