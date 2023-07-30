import request from '@/utils/request'

export function insertTrip(data) {
  request({
    url: '/trip/manage',
    method: 'post',
    data: data
  })
}
