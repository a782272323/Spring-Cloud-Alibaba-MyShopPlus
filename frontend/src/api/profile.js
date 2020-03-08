import request from '@/utils/request'

/**
 * 获取个人信息
 * @param params
 * @returns {AxiosPromise}
 */
export function info(username) {
  return request({
    url: '/profile/info/' + username,
    method: 'get',
    // params
  })
}
