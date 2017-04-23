package com.pangciyuan.note.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteBookExample() {
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

        public Criteria andNoteBookIdIsNull() {
            addCriterion("note_book_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdIsNotNull() {
            addCriterion("note_book_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdEqualTo(Integer value) {
            addCriterion("note_book_id =", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdNotEqualTo(Integer value) {
            addCriterion("note_book_id <>", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdGreaterThan(Integer value) {
            addCriterion("note_book_id >", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_book_id >=", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdLessThan(Integer value) {
            addCriterion("note_book_id <", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("note_book_id <=", value, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdIn(List<Integer> values) {
            addCriterion("note_book_id in", values, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdNotIn(List<Integer> values) {
            addCriterion("note_book_id not in", values, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdBetween(Integer value1, Integer value2) {
            addCriterion("note_book_id between", value1, value2, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("note_book_id not between", value1, value2, "noteBookId");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameIsNull() {
            addCriterion("note_book_name is null");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameIsNotNull() {
            addCriterion("note_book_name is not null");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameEqualTo(String value) {
            addCriterion("note_book_name =", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameNotEqualTo(String value) {
            addCriterion("note_book_name <>", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameGreaterThan(String value) {
            addCriterion("note_book_name >", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("note_book_name >=", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameLessThan(String value) {
            addCriterion("note_book_name <", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameLessThanOrEqualTo(String value) {
            addCriterion("note_book_name <=", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameLike(String value) {
            addCriterion("note_book_name like", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameNotLike(String value) {
            addCriterion("note_book_name not like", value, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameIn(List<String> values) {
            addCriterion("note_book_name in", values, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameNotIn(List<String> values) {
            addCriterion("note_book_name not in", values, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameBetween(String value1, String value2) {
            addCriterion("note_book_name between", value1, value2, "noteBookName");
            return (Criteria) this;
        }

        public Criteria andNoteBookNameNotBetween(String value1, String value2) {
            addCriterion("note_book_name not between", value1, value2, "noteBookName");
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

        public Criteria andNoteBookTypeIsNull() {
            addCriterion("note_book_type is null");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeIsNotNull() {
            addCriterion("note_book_type is not null");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeEqualTo(Integer value) {
            addCriterion("note_book_type =", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeNotEqualTo(Integer value) {
            addCriterion("note_book_type <>", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeGreaterThan(Integer value) {
            addCriterion("note_book_type >", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_book_type >=", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeLessThan(Integer value) {
            addCriterion("note_book_type <", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeLessThanOrEqualTo(Integer value) {
            addCriterion("note_book_type <=", value, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeIn(List<Integer> values) {
            addCriterion("note_book_type in", values, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeNotIn(List<Integer> values) {
            addCriterion("note_book_type not in", values, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeBetween(Integer value1, Integer value2) {
            addCriterion("note_book_type between", value1, value2, "noteBookType");
            return (Criteria) this;
        }

        public Criteria andNoteBookTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("note_book_type not between", value1, value2, "noteBookType");
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