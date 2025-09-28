// Problem link: https://open.kattis.com/problems/acm;
#include <iostream>
#include <map>
#include <string>

int main() {
    std::map<char, int> wrong_ans_count;
    std::map<char, int> right_ans;
    int time {0};
    char letter {};
    std::string verdict {};
    while (true) {
        std::cin >> time;
        if (time == -1) {
            break;
        }
        std::cin >> letter >> verdict;
        if (verdict == "right") {
            right_ans.insert({letter, time});
        } else {
            wrong_ans_count[letter]++;
        }
    }
    int score {0};
    for (const auto& [key, value]: right_ans) {
        score += value + wrong_ans_count[key] * 20;
    }

    std::cout << right_ans.size() << " " << score << '\n';


}
