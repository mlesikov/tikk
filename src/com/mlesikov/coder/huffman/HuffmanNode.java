package com.mlesikov.coder.huffman;

import com.mlesikov.textanalyzing.TextCharFrequency;

/**
 * Created by Mihail Lesikov.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private Character element; // bukva
    private Double weight;
    private String code = "";
    private HuffmanNode parent;
    private HuffmanNode leftChild;
    private HuffmanNode rightChild;

    public static HuffmanNode from(TextCharFrequency charFrequency) {
        HuffmanNode node = new HuffmanNode(charFrequency.getCharacter(), charFrequency.getFrequencyPercent());
        return node;
    }

    public HuffmanNode(Character element, double weight) {
        this.element = element;
        this.weight = weight;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public HuffmanNode(double weight) {
        this(null, weight);
    }

    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    public Character getElement() {
        return element;
    }

    public Double getWeight() {
        return weight;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public HuffmanNode getParent() {
        return parent;
    }

    public void setParent(HuffmanNode parent) {
        this.parent = parent;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HuffmanNode)) {
            return false;
        }
        HuffmanNode other = (HuffmanNode) obj;
        return this.element == other.element;
    }

    public int hashCode() {
        return (int) element;
    }

    public int compareTo(HuffmanNode o) {
        double result = o.weight - weight;
        if (result == 0) {
            return 0;
        } else if (result > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "element=" + element +
                ", weight=" + weight +
                ", code='" + code + '\'' +
                '}';
    }

}
