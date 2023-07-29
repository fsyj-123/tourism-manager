import request from '@/utils/request'

// 查询饭店管理列表
export function listManage(query) {
  return request({
    url: '/hotel/manage/list',
    method: 'get',
    params: query
  })
}

// 查询饭店管理详细
export function getManage(id) {
  return request({
    url: '/hotel/manage/' + id,
    method: 'get'
  })
}

// 新增饭店管理
export function addManage(data) {
  return request({
    url: '/hotel/manage',
    method: 'post',
    data: data
  })
}

// 修改饭店管理
export function updateManage(data) {
  return request({
    url: '/hotel/manage',
    method: 'put',
    data: data
  })
}

// 删除饭店管理
export function delManage(id) {
  return request({
    url: '/hotel/manage/' + id,
    method: 'delete'
  })
}
