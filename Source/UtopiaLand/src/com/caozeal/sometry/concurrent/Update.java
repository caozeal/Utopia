package com.caozeal.sometry.concurrent;

import java.util.Objects;

/**
 * 构造器模式
 * @author caozhiyong
 */
public class Update {

    private final Author author;
    private final String updateText;

    private Update(Builder builder){
        author = builder.author;
        updateText = builder.updataText;
    }

    @Override
    public String toString() {
        return "Update{" +
                "author=" + author +
                ", updateText='" + updateText + '\'' +
                '}';
    }

    public Author getAuthor() {
        return author;
    }

    public String getUpdateText() {
        return updateText;
    }

    public static class Builder implements ObjBuilder<Update>{
        private Author author;
        private String updataText;

        public Builder author(Author author){
            this.author = author;
            return this;
        }

        public Builder updateText(String text){
            this.updataText = text;
            return this;
        }

        @Override
        public Update builder() {
            return new Update(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(author, builder.author) &&
                    Objects.equals(updataText, builder.updataText);
        }

        @Override
        public int hashCode() {

            return Objects.hash(author, updataText);
        }
    }

}
