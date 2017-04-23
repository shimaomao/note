package com.pangciyuan.note.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
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

        public Criteria andNoteTitleIsNull() {
            addCriterion("note_title is null");
            return (Criteria) this;
        }

        public Criteria andNoteTitleIsNotNull() {
            addCriterion("note_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTitleEqualTo(String value) {
            addCriterion("note_title =", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotEqualTo(String value) {
            addCriterion("note_title <>", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleGreaterThan(String value) {
            addCriterion("note_title >", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("note_title >=", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLessThan(String value) {
            addCriterion("note_title <", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLessThanOrEqualTo(String value) {
            addCriterion("note_title <=", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLike(String value) {
            addCriterion("note_title like", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotLike(String value) {
            addCriterion("note_title not like", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleIn(List<String> values) {
            addCriterion("note_title in", values, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotIn(List<String> values) {
            addCriterion("note_title not in", values, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleBetween(String value1, String value2) {
            addCriterion("note_title between", value1, value2, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotBetween(String value1, String value2) {
            addCriterion("note_title not between", value1, value2, "noteTitle");
            return (Criteria) this;
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

        public Criteria andNoteBookTagIsNull() {
            addCriterion("note_book_tag is null");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagIsNotNull() {
            addCriterion("note_book_tag is not null");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagEqualTo(String value) {
            addCriterion("note_book_tag =", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagNotEqualTo(String value) {
            addCriterion("note_book_tag <>", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagGreaterThan(String value) {
            addCriterion("note_book_tag >", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagGreaterThanOrEqualTo(String value) {
            addCriterion("note_book_tag >=", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagLessThan(String value) {
            addCriterion("note_book_tag <", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagLessThanOrEqualTo(String value) {
            addCriterion("note_book_tag <=", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagLike(String value) {
            addCriterion("note_book_tag like", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagNotLike(String value) {
            addCriterion("note_book_tag not like", value, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagIn(List<String> values) {
            addCriterion("note_book_tag in", values, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagNotIn(List<String> values) {
            addCriterion("note_book_tag not in", values, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagBetween(String value1, String value2) {
            addCriterion("note_book_tag between", value1, value2, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteBookTagNotBetween(String value1, String value2) {
            addCriterion("note_book_tag not between", value1, value2, "noteBookTag");
            return (Criteria) this;
        }

        public Criteria andNoteStateIsNull() {
            addCriterion("note_state is null");
            return (Criteria) this;
        }

        public Criteria andNoteStateIsNotNull() {
            addCriterion("note_state is not null");
            return (Criteria) this;
        }

        public Criteria andNoteStateEqualTo(Integer value) {
            addCriterion("note_state =", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateNotEqualTo(Integer value) {
            addCriterion("note_state <>", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateGreaterThan(Integer value) {
            addCriterion("note_state >", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_state >=", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateLessThan(Integer value) {
            addCriterion("note_state <", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateLessThanOrEqualTo(Integer value) {
            addCriterion("note_state <=", value, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateIn(List<Integer> values) {
            addCriterion("note_state in", values, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateNotIn(List<Integer> values) {
            addCriterion("note_state not in", values, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateBetween(Integer value1, Integer value2) {
            addCriterion("note_state between", value1, value2, "noteState");
            return (Criteria) this;
        }

        public Criteria andNoteStateNotBetween(Integer value1, Integer value2) {
            addCriterion("note_state not between", value1, value2, "noteState");
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