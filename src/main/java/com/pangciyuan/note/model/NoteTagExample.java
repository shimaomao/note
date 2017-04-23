package com.pangciyuan.note.model;

import java.util.ArrayList;
import java.util.List;

public class NoteTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteTagExample() {
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

        public Criteria andNoteTagIdIsNull() {
            addCriterion("note_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdIsNotNull() {
            addCriterion("note_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdEqualTo(Integer value) {
            addCriterion("note_tag_id =", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdNotEqualTo(Integer value) {
            addCriterion("note_tag_id <>", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdGreaterThan(Integer value) {
            addCriterion("note_tag_id >", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_tag_id >=", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdLessThan(Integer value) {
            addCriterion("note_tag_id <", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("note_tag_id <=", value, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdIn(List<Integer> values) {
            addCriterion("note_tag_id in", values, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdNotIn(List<Integer> values) {
            addCriterion("note_tag_id not in", values, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdBetween(Integer value1, Integer value2) {
            addCriterion("note_tag_id between", value1, value2, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("note_tag_id not between", value1, value2, "noteTagId");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameIsNull() {
            addCriterion("note_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameIsNotNull() {
            addCriterion("note_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameEqualTo(String value) {
            addCriterion("note_tag_name =", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameNotEqualTo(String value) {
            addCriterion("note_tag_name <>", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameGreaterThan(String value) {
            addCriterion("note_tag_name >", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("note_tag_name >=", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameLessThan(String value) {
            addCriterion("note_tag_name <", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameLessThanOrEqualTo(String value) {
            addCriterion("note_tag_name <=", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameLike(String value) {
            addCriterion("note_tag_name like", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameNotLike(String value) {
            addCriterion("note_tag_name not like", value, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameIn(List<String> values) {
            addCriterion("note_tag_name in", values, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameNotIn(List<String> values) {
            addCriterion("note_tag_name not in", values, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameBetween(String value1, String value2) {
            addCriterion("note_tag_name between", value1, value2, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagNameNotBetween(String value1, String value2) {
            addCriterion("note_tag_name not between", value1, value2, "noteTagName");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateIsNull() {
            addCriterion("note_tag_state is null");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateIsNotNull() {
            addCriterion("note_tag_state is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateEqualTo(Integer value) {
            addCriterion("note_tag_state =", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateNotEqualTo(Integer value) {
            addCriterion("note_tag_state <>", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateGreaterThan(Integer value) {
            addCriterion("note_tag_state >", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("note_tag_state >=", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateLessThan(Integer value) {
            addCriterion("note_tag_state <", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateLessThanOrEqualTo(Integer value) {
            addCriterion("note_tag_state <=", value, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateIn(List<Integer> values) {
            addCriterion("note_tag_state in", values, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateNotIn(List<Integer> values) {
            addCriterion("note_tag_state not in", values, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateBetween(Integer value1, Integer value2) {
            addCriterion("note_tag_state between", value1, value2, "noteTagState");
            return (Criteria) this;
        }

        public Criteria andNoteTagStateNotBetween(Integer value1, Integer value2) {
            addCriterion("note_tag_state not between", value1, value2, "noteTagState");
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