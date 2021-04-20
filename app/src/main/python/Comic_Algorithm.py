# coding = utf-8

# coding = utf-8

# 基于用户的协同过滤推荐算法实现

import math
from operator import itemgetter
from os.path import dirname, join

# 初始化相关参数
# 找到与目标用户兴趣相似的20个用户，为其推荐10部电影
n_sim_user = 20
n_rec_movie = 15
trainSet_len = 0

# 将数据集划分为训练集和测试集
trainSet = {}

# 用户相似度矩阵
user_sim_matrix = {}



# 读文件得到“用户-电影”数据
def get_dataset(list):
    trainSet_len = 0
    for index in range(list.size()):
        line = list.get(index)
        userId = line.userId
        movieId = line.movieId
        rating = line.rating
        trainSet.setdefault(str(userId), {})
        trainSet[str(userId)][str(movieId)] = rating
        trainSet_len += 1
    print("test 读取结束：%s" % trainSet_len)


def calc_user_sim(watched_movies):
    # 构建“电影-用户”倒排索引
    # key = movieID, value = list of userIDs who have seen this movie
    movie_user = {}
    for user, movies in trainSet.items():
        if not watched_movies.containsKey(movie):
            continue
        for movie in movies:
            if movie not in movie_user:
                movie_user[movie] = set()
            movie_user[movie].add(user)

    for movie, users in movie_user.items():
        for u in users:
            user_sim_matrix.setdefault(u, 0)
            user_sim_matrix[u] += 1

    # 计算相似性
    for u, count in user_sim_matrix.items():
        user_sim_matrix[u] = count / math.sqrt(len(trainSet[u]) * watched_movies.size())

    # 针对目标用户U，找到其最相似的K个用户，产生N个推荐


def recommend(watched_movies):
    K = n_sim_user
    N = n_rec_movie
    rank = {}
    calc_user_sim(watched_movies)
    # v=similar user, wuv=similar factor
    for v, wuv in sorted(user_sim_matrix.items(), key=itemgetter(1), reverse=True)[0:K]:
        for movie in trainSet[v]:
            if watched_movies.containsKey(movie):
                continue
            rank.setdefault(movie, 0.0)
            rank[movie] += wuv * float(trainSet[v][movie])
    return sorted(rank.items(), key=itemgetter(1), reverse=True)[0:N]

# if __name__ == '__main__':
#     userCF = UserBasedCF()
#     userCF.get_dataset(rating_file)
#     watched_movies = {}
#     watched_movies.setdefault("296",0)
#     watched_movies.setdefault("1175",0)
#     watched_movies.setdefault("1260",0)
#     watched_movies["296"] = 2.5
#     watched_movies["1175"] = 3.5
#     watched_movies["1260"] = 5
#     test = userCF.recommend(watched_movies)
#     print(len(test))
#     for t in test:
#         print(t)
