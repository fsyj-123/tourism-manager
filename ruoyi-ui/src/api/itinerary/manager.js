import request from '@/utils/request'

// 查询行程单列表
export function listManager(query) {
  return request({
    url: '/itinerary/manager/list',
    method: 'get',
    params: query
  })
}

// 查询行程单详细
export function getManager(itineraryId) {
  return request({
    url: '/itinerary/manager/' + itineraryId,
    method: 'get'
  })
}

// 新增行程单
export function addManager(data) {
  return request({
    url: '/itinerary/manager',
    method: 'post',
    data: data
  })
}

// 修改行程单
export function updateManager(data) {
  return request({
    url: '/itinerary/manager',
    method: 'put',
    data: data
  })
}

// 删除行程单
export function delManager(itineraryId) {
  return request({
    url: '/itinerary/manager/' + itineraryId,
    method: 'delete'
  })
}
