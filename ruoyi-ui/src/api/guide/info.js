import request from '@/utils/request'

// 查询登记注册列表
export function listInfo(query) {
  return request({
    url: '/guide/info/list',
    method: 'get',
    params: query
  })
}


// 查询登记注册详细
export function getInfo() {
  return request({
    url: '/guide/info/' + id,
    method: 'get'
  })
}

export function listInfoAll(phone) {
  return request({
    url: '/guide/info/' + phone,
    method: 'get'
  })

}

// 新增登记注册
export function addInfo(data) {
  return request({
    url: '/guide/info',
    method: 'post',
    data: data
  })
}

// 修改登记注册
export function updateInfo(data) {
  return request({
    url: '/guide/info',
    method: 'put',
    data: data
  })
}

// 删除登记注册
export function delInfo(id) {
  return request({
    url: '/guide/info/' + id,
    method: 'delete'
  })
}
export function getGuideInfo() {
  return request({
    url: '/guide/info/phone',
    method: 'get'
  })
}
