package cn.plusman.arithmetic.leetcode.top.top127;

import java.util.*;

/**
 * @author plusman
 * @since 2021/10/14 10:46 PM
 */
public class Top127Class implements Top127Solution {
    @Override
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 首先排除接龙列表内无目标词的情况
        boolean isNotExists = true;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                isNotExists = false;
                break;
            }
        }
        if (isNotExists) {
            return 0;
        }
        
        Set<String> nextWords = findWords(wordList, new HashSet<>(Arrays.asList(beginWord)), endWord);
        int depth = 1;
        
        while (!nextWords.isEmpty()) {
            depth++;
            
            // 判断是否找到 endWord
            for (String word : nextWords) {
                if (word.equals(endWord)) {
                    return depth;
                }
            }
            
            // 无需往回查找
            wordList.removeAll(nextWords);
            
            nextWords = findWords(wordList, nextWords, endWord);
        }
        
        return 0;
    }
    
    protected Set<String> findWords(List<String> wordList, Set<String> levelWords, String endWord) {
        Set<String> matchWords = new HashSet<>();
    
        for (String levelWord : levelWords) {
            for (String word : wordList) {
                if (isCanTransfer(levelWord, word)){
                    if(word.equals(endWord)) {
                        matchWords.clear();
                        matchWords.add(word);
                        return matchWords;
                    }
                    matchWords.add(word);
                }
            }
        }
        
        return matchWords;
    } 
    
    protected boolean isCanTransfer(String source, String target) {
        int diff = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                diff++;
            }
            
            if (diff > 1) {
                return false;
            }
        }
        
        return diff != 0;
    }
}
