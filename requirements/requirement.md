## 需求描述：

1. 游戏有四个格子，每个格子有一个0到9的数字，任意两个格子的数字都不一样，四个格子的数字在游戏开始时随机生成；
2. 玩家依序输入四个数字，输入数字不满足“四个0到9的数字，且互不相同”时，游戏反馈“输入不正确，重新输入”，输入数字满足“四个0到9的数字，且互不相同”时，程序会给出xAxB的反馈，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数；
3. 玩家有6次猜测机会，每次猜测时，游戏会给出当前猜测结果，以及之前所有猜测数字和结果供玩家参考，当玩家猜对时，输出“胜出 全中”，当玩家猜测6次未成功，输出“六次猜测失败，游戏结束”。

## 核心需求：

1. 游戏随机生成四个0到9且互不相同的数字；
2. 对玩家输入数字做有效性判定，满足“四个0到9且互不相同的数字”为有效；
3. 玩家输入数字无效时，游戏反馈“输入不正确，重新输入”，输入数字有效时，游戏反馈xAxB，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数。
4. 玩家猜测时，游戏输出当前猜测结果及玩家之前所有猜测的数字和结果。
5. 玩家有6次猜测机会, 当玩家猜对时，游戏输出“胜出 全中”，当玩家猜测六次未成功，游戏输出“六次猜测失败，游戏结束”


## 实现步骤：
Task 1:

1. 输入四个0到9且互不相同的数字，输出猜测是否成功，以及提示消息xAxB，A前面的数字代表位置和数字都对的个数，B前面的数字代表数字对但是位置不对的个数; AnswerCheckerTest -> AnswerChecker
2. 输入数字验证无效时，输出猜测失败，并提示“输入不正确，重新输入”；AnswerCheckerTest -> AnswerChecker
3. 当玩家猜对时，输出“胜出 全中”，当玩家猜测六次未成功，输出“六次猜测失败，游戏结束”; GuessNumberGameTest -> GuessNumberGame
4. 输出玩家的游戏记录（之前猜测数据和结果）
5. 实现游戏答案生成器，随机生成四个0到9且互不相同的数字；AnswerGeneratorTest －> AnswerGenerator
6. 判断输入数字序列是否有效：“四个0到9且互不相同的数字”，无效时抛出异常；NumbersValidatorTest －> NumbersValidator
