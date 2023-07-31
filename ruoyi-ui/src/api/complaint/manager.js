import request from '@/utils/request'

// 查询游客投诉管理列表
export function listManager(query) {
  return request({
    url: '/complaint/manager/list',
    method: 'get',
    params: query
  })
}

// 查询游客投诉管理详细
export function getManager(complaintId) {
  return request({
    url: '/complaint/manager/' + complaintId,
    method: 'get'
  })
}

// 新增游客投诉管理
export function addManager(data) {
  return request({
    url: '/complaint/manager',
    method: 'post',
    data: data
  })
}

// 修改游客投诉管理
export function updateManager(data) {
  return request({
    url: '/complaint/manager',
    method: 'put',
    data: data
  })
}

// 删除游客投诉管理
export function delManager(complaintId) {
  return request({
    url: '/complaint/manager/' + complaintId,
    method: 'delete'
  })
}
