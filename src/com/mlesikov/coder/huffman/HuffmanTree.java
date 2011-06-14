package com.mlesikov.coder.huffman;

import com.mlesikov.textanalyzing.TextCharFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mihail Lesikov.
 */
public class HuffmanTree {
    private HuffmanNode root = null;
    private List<HuffmanNode> nodeList;

    public HuffmanTree() {
    }


    public void buildTree(List<TextCharFrequency> textCharFrequencies) {
        nodeList = getInitialNodeList(textCharFrequencies);
        List<HuffmanNode> leafNodeList = new ArrayList<HuffmanNode>(nodeList.size());
        leafNodeList.addAll(nodeList);

        HuffmanNode lc = null;
        HuffmanNode rc = null;
        HuffmanNode parent = null;

        int lastOneIndex = -1, lastTwoIndex = -1;
        while (leafNodeList.size() > 1) {
            Collections.sort(leafNodeList);

            lastOneIndex = leafNodeList.size() - 1;
            lastTwoIndex = leafNodeList.size() - 2;

            lc = leafNodeList.get(lastOneIndex);
            rc = leafNodeList.get(lastTwoIndex);

            leafNodeList.remove(lastOneIndex);
            leafNodeList.remove(lastTwoIndex);

            parent = new HuffmanNode(lc.getWeight() + rc.getWeight());
            lc.setParent(parent);
            rc.setParent(parent);

            parent.setLeftChild(lc);
            parent.setRightChild(rc);

            leafNodeList.add(parent);
        }

        leafNodeList.clear();
        root = parent;

        generateNodeCode(root);
    }

    private List<HuffmanNode> getInitialNodeList(List<TextCharFrequency> textCharFrequencies) {
        List<HuffmanNode> initialNodeList = new ArrayList<HuffmanNode>();
        for (TextCharFrequency charFrequency : textCharFrequencies) {
            initialNodeList.add(HuffmanNode.from(charFrequency));
        }
        return initialNodeList;
    }


    public List<HuffmanNode> getNodeList() {
        return nodeList;
    }

    public HuffmanNode getRoot() {
        return root;
    }

    private void generateNodeCode(HuffmanNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            updateCode(node.getLeftChild(), "0");
            updateCode(node.getRightChild(), "1");
        }
        generateNodeCode(node.getLeftChild());
        generateNodeCode(node.getRightChild());
    }

    private void updateCode(HuffmanNode node, String symbol) {
        String parentCode = node.getParent().getCode();
        node.setCode(parentCode + symbol);
    }


}
