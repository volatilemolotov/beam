FROM mitmproxy/mitmproxy:9.0.1


COPY ../../../infrastructure/proxy/allow_list_proxy.py /home/mitmproxy/
COPY ../../../infrastructure/proxy/allow_list.py /home/mitmproxy/
COPY entrypoint.sh /

ENTRYPOINT ["/entrypoint.sh"]
